
/*
 * Copyright (c) 2020 OpenFTC Team
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Control.AutonomousControl;
import org.firstinspires.ftc.teamcode.Control.Goal;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvPipeline;

@Autonomous(name="January Auton", group = "basic")
public class JanuaryAuton extends AutonomousControl
{
    SkystoneDeterminationPipeline pipeline;


    @Override
    public void runOpMode() throws InterruptedException
    {
        setup(runtime, Goal.setupType.openCV, Goal.setupType.autonomous);
        telemetry.addLine("Start!");
        telemetry.update();

        pipeline = new SkystoneDeterminationPipeline();
        rob.webcam.setPipeline(pipeline);

        //
        // We set the viewport policy to optimized view so the preview doesn't appear 90 deg
        // out when the RC activity is in portrait.We do our actual image processing assuming
        // landscape orientation, though.

        rob.webcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
        {
            @Override
            public void onOpened()
            {
                rob.webcam.startStreaming(320,240);
            }
        });

        double currTime = runtime.milliseconds();

        waitForStart();

        if (opModeIsActive())
        {
            rob.driveTrainEncoderMovement(0.5, 30, 4, 0, Goal.movements.forward);

            while(runtime.milliseconds() < 5000) {
                telemetry.addData("Analysis", pipeline.getAnalysis());
                telemetry.addData("Position", pipeline.position);
                telemetry.addData("Value", pipeline.value);
                telemetry.update();

                // Don't burn CPU cycles busy-looping in this sample
                sleep(50);
            }
            int dist;
            if (pipeline.value == 4){
                dist = 114;
            }else if(pipeline.value == 1){
                dist = 90;
            }else{
                dist = 66;

            }
            //move to red square
            rob.driveTrainEncoderMovement(1,dist,20,0,Goal.movements.forward);

            //drop wobble goal
            rob.pinch.setPosition(0.8);
            sleep(500);
            rob.claw.setPower(0.3);
            sleep(500);
            rob.claw.setPower(0);
            sleep(250);


            //move back to pick up second wobble goal

            rob.driveTrainEncoderMovement(1,dist - 10,20,0,Goal.movements.backward);

            rob.lifter.setPosition(.84);
            sleep(200);

            rob.driveTrainEncoderMovement(1,6,20,0,Goal.movements.left);

            // turn to face second wobble goal
            rob.driveTrainEncoderMovement(1,23,20,0,Goal.movements.cw);

            rob.pinch.setPosition(0.8);
            sleep(500);

            // move to second wobble goal
            rob.driveTrainEncoderMovement(.75,16,20,0,Goal.movements.forward);

            // pick up second wobble goal
            sleep(250);
            rob.claw.setPower(-0.3);
            sleep(300);
            rob.claw.setPower(0);
            sleep(500);
            rob.pinch.setPosition(0);
            sleep(400);
            rob.claw.setPower(-0.4);
            sleep(350);
            rob.claw.setPower(0);
            sleep(250);

            // move backwards to go back to red square
            rob.driveTrainEncoderMovement(1,23,20,0,Goal.movements.ccw);
            rob.driveTrainEncoderMovement(1,23,20,0,Goal.movements.right);
            rob.driveTrainEncoderMovement(1,42,20,0,Goal.movements.forward);

            //drop wobble goal
            rob.pinch.setPosition(0.8);
            sleep(250);
            rob.claw.setPower(0.3);
            sleep(500);
            rob.claw.setPower(0);
            sleep(250);

            // start flywheel
//          rob.fly.setPower(-0.635);
            rob.fly.setPower(-0.73);
            sleep(2000);

            // move backwards a bit so you dont hit the wobble goal
            rob.driveTrainEncoderMovement(1,7,20,0,Goal.movements.backward);

            // move towards wall
            // rob.driveTrainEncoderMovement(1,9,20, 0, Goal.movements.right);

            // move to the left, to align shots
//          rob.driveTrainEncoderMovement(1,44,20,0,Goal.movements.left);
            rob.driveTrainEncoderMovement(1,22 ,20,0,Goal.movements.left);

            // move to right behind white line
            rob.driveTrainEncoderMovement(1,9,20,0,Goal.movements.forward);



            sleep(500);
            for(int i = 0; i<=2; i++) {
                rob.fly.setPower(-0.73);
                sleep(200);
                //200
                rob.whack.setPosition(0.62);
                sleep(1000);
                //1000 each
                rob.whack.setPosition(0);
                sleep(1000);
            }

            // move to Launch Line
            rob.driveTrainEncoderMovement(1,8, 100, 100,Goal.movements.forward);


        }
    }

    public static class SkystoneDeterminationPipeline extends OpenCvPipeline
    {
        /*
         * An enum to define the skystone position
         */
        public enum RingPosition
        {
            FOUR,
            ONE,
            NONE
        }

        public int value = 0;
        /*
         * Some color constants
         */
        static final Scalar BLUE = new Scalar(0, 0, 255);
        static final Scalar GREEN = new Scalar(0, 255, 0);

        /*
         * The core values which define the location and size of the sample regions
         */
        static final Point REGION1_TOPLEFT_ANCHOR_POINT = new Point(100,98);

        static final int REGION_WIDTH = 100;
        static final int REGION_HEIGHT = 100;

        final int FOUR_RING_THRESHOLD = 147;
        final int ONE_RING_THRESHOLD = 135;

        Point region1_pointA = new Point(
                REGION1_TOPLEFT_ANCHOR_POINT.x,
                REGION1_TOPLEFT_ANCHOR_POINT.y);
        Point region1_pointB = new Point(
                REGION1_TOPLEFT_ANCHOR_POINT.x + REGION_WIDTH,
                REGION1_TOPLEFT_ANCHOR_POINT.y + REGION_HEIGHT);

        /*
         * Working variables
         */
        Mat region1_Cb;
        Mat YCrCb = new Mat();
        Mat Cb = new Mat();
        int avg1;

        // Volatile since accessed by OpMode thread w/o synchronization
        public volatile RingPosition position = RingPosition.FOUR;

        /*
         * This function takes the RGB frame, converts to YCrCb,
         * and extracts the Cb channel to the 'Cb' variable
         */
        void inputToCb(Mat input)
        {
            Imgproc.cvtColor(input, YCrCb, Imgproc.COLOR_RGB2YCrCb);
            Core.extractChannel(YCrCb, Cb, 1);
        }

        @Override
        public void init(Mat firstFrame)
        {
            inputToCb(firstFrame);

            region1_Cb = Cb.submat(new Rect(region1_pointA, region1_pointB));
        }

        @Override
        public Mat processFrame(Mat input)
        {
            inputToCb(input);

            avg1 = (int) Core.mean(region1_Cb).val[0];

            Imgproc.rectangle(
                    input, // Buffer to draw on
                    region1_pointA, // First point which defines the rectangle
                    region1_pointB, // Second point which defines the rectangle
                    BLUE, // The color the rectangle is drawn in
                    2); // Thickness of the rectangle lines

            position = RingPosition.FOUR; // Record our analysis
            if(avg1 > FOUR_RING_THRESHOLD){
                position = RingPosition.FOUR;
                value = 4;
            }else if (avg1 > ONE_RING_THRESHOLD){
                position = RingPosition.ONE;
                value = 1;
            }else{
                position = RingPosition.NONE;
                value = 0;
            }

            Imgproc.rectangle(
                    input, // Buffer to draw on
                    region1_pointA, // First point which defines the rectangle
                    region1_pointB, // Second point which defines the rectangle
                    GREEN, // The color the rectangle is drawn in
                    -1); // Negative thickness means solid fill

            return input;
        }

        public int getAnalysis()
        {
            return avg1;
        }
    }
}