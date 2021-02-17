package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Control.AutonomousControl;
import org.firstinspires.ftc.teamcode.Control.Goal;

@Autonomous(name="AutoCV", group = "basic")

public class AutonomousOpenCV extends AutonomousControl {

    EasyOpenCV.SkystoneDeterminationPipeline pipeline;

    @Override
    public void runOpMode() throws InterruptedException {

        setup(runtime, Goal.setupType.autonomous);
        telemetry.addLine("Start!");
        telemetry.update();

        if (opModeIsActive()) {

            pipeline = new EasyOpenCV.SkystoneDeterminationPipeline();
            rob.webcam.setPipeline(pipeline);

            while (runtime.milliseconds() < 3000) {
                telemetry.addData("Analysis", pipeline.getAnalysis());
                telemetry.addData("Position", pipeline.position);
                telemetry.addData("Value", pipeline.value);
                telemetry.update();

                // Don't burn CPU cycles busy-looping in this sample
                sleep(50);
            }

            if (pipeline.value == 4) {
                four();
            } else if (pipeline.value == 1) {
                one();
            } else {
                zero();
            }
        }
    }

    public void four() throws InterruptedException {

        // pick up wobble goal
        //            rob.claw.setPower(-0.4);
        //            sleep(750);
        //            rob.claw.setPower(0);
        //            sleep(250);

        //move to red square
        //    rob.driveTrainEncoderMovement(1,10,20,0,Goal.movements.right);
        rob.driveTrainEncoderMovement(1, 75, 20, 0, Goal.movements.forward);
        // previous 63

        //drop wobble goal
        rob.pinch.setPosition(0.8);
        sleep(500);
        rob.claw.setPower(0.3);
        sleep(500);
        rob.claw.setPower(0);
        sleep(250);


        //move back to pick up second wobble goal

        rob.driveTrainEncoderMovement(1, 55, 20, 0, Goal.movements.backward);

        rob.lifter.setPosition(.84);
        sleep(200);

        rob.driveTrainEncoderMovement(1, 6, 20, 0, Goal.movements.left);

        // turn to face second wobble goal
        rob.driveTrainEncoderMovement(1, 23, 20, 0, Goal.movements.cw);

        rob.pinch.setPosition(0.8);
        sleep(500);

        // move to second wobble goal
        rob.driveTrainEncoderMovement(.75, 16, 20, 0, Goal.movements.forward);

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
        //            rob.driveTrainEncoderMovement(1,15,20,0,Goal.movements.backward);
        rob.driveTrainEncoderMovement(1, 23, 20, 0, Goal.movements.ccw);
        rob.driveTrainEncoderMovement(1, 23, 20, 0, Goal.movements.right);
        rob.driveTrainEncoderMovement(1, 51, 20, 0, Goal.movements.forward);

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
        rob.driveTrainEncoderMovement(1, 16, 20, 0, Goal.movements.backward);

        // move towards wall
        // rob.driveTrainEncoderMovement(1,9,20, 0, Goal.movements.right);

        // move to the left, to align shots
        //          rob.driveTrainEncoderMovement(1,44,20,0,Goal.movements.left);
        rob.driveTrainEncoderMovement(1, 22, 20, 0, Goal.movements.left);

        // move to right behind white line
        rob.driveTrainEncoderMovement(1, 9, 20, 0, Goal.movements.forward);


        //            rob.fly.setPower(-0.72);
        //            sleep(2000);
        // 2000

        // shoot your shots

        sleep(500);
        for (int i = 0; i <= 2; i++) {
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
        rob.driveTrainEncoderMovement(1, 8, 100, 100, Goal.movements.forward);
    }

    public void one() throws InterruptedException {

        // pick up wobble goal
        //            rob.claw.setPower(-0.4);
        //            sleep(750);
        //            rob.claw.setPower(0);
        //            sleep(250);

        //move to red square
        //    rob.driveTrainEncoderMovement(1,10,20,0,Goal.movements.right);
        rob.driveTrainEncoderMovement(1, 70, 20, 0, Goal.movements.forward);

        //drop wobble goal
        rob.pinch.setPosition(0.8);
        sleep(500);
        rob.claw.setPower(0.3);
        sleep(500);
        rob.claw.setPower(0);
        sleep(250);


        //move back to pick up second wobble goal

        rob.driveTrainEncoderMovement(1, 50, 20, 0, Goal.movements.backward);

        rob.lifter.setPosition(.84);
        sleep(200);

        rob.driveTrainEncoderMovement(1, 6, 20, 0, Goal.movements.left);

        // turn to face second wobble goal
        rob.driveTrainEncoderMovement(1, 23, 20, 0, Goal.movements.cw);

        rob.pinch.setPosition(0.8);
        sleep(500);

        // move to second wobble goal
        rob.driveTrainEncoderMovement(.75, 16, 20, 0, Goal.movements.forward);

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
        //            rob.driveTrainEncoderMovement(1,15,20,0,Goal.movements.backward);
        rob.driveTrainEncoderMovement(1, 23, 20, 0, Goal.movements.ccw);
        rob.driveTrainEncoderMovement(1, 23, 20, 0, Goal.movements.right);
        rob.driveTrainEncoderMovement(1, 46, 20, 0, Goal.movements.forward);

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
        rob.driveTrainEncoderMovement(1, 11, 20, 0, Goal.movements.backward);

        // move towards wall
        // rob.driveTrainEncoderMovement(1,9,20, 0, Goal.movements.right);

        // move to the left, to align shots
        //          rob.driveTrainEncoderMovement(1,44,20,0,Goal.movements.left);
        rob.driveTrainEncoderMovement(1, 22, 20, 0, Goal.movements.left);

        // move to right behind white line
        rob.driveTrainEncoderMovement(1, 9, 20, 0, Goal.movements.forward);


        //            rob.fly.setPower(-0.72);
        //            sleep(2000);
        // 2000

        // shoot your shots

        sleep(500);
        for (int i = 0; i <= 2; i++) {
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
        rob.driveTrainEncoderMovement(1, 8, 100, 100, Goal.movements.forward);
    }

    public void zero() throws InterruptedException {

        // pick up wobble goal
        //            rob.claw.setPower(-0.4);
        //            sleep(750);
        //            rob.claw.setPower(0);
        //            sleep(250);

        //move to red square
        //    rob.driveTrainEncoderMovement(1,10,20,0,Goal.movements.right);
        rob.driveTrainEncoderMovement(1, 66, 20, 0, Goal.movements.forward);
        // previous 63

        //drop wobble goal
        rob.pinch.setPosition(0.8);
        sleep(500);
        rob.claw.setPower(0.3);
        sleep(500);
        rob.claw.setPower(0);
        sleep(250);


        //move back to pick up second wobble goal

        rob.driveTrainEncoderMovement(1, 46, 20, 0, Goal.movements.backward);

        rob.lifter.setPosition(.84);
        sleep(200);

        rob.driveTrainEncoderMovement(1, 6, 20, 0, Goal.movements.left);

        // turn to face second wobble goal
        rob.driveTrainEncoderMovement(1, 23, 20, 0, Goal.movements.cw);

        rob.pinch.setPosition(0.8);
        sleep(500);

        // move to second wobble goal
        rob.driveTrainEncoderMovement(.75, 16, 20, 0, Goal.movements.forward);

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
        //            rob.driveTrainEncoderMovement(1,15,20,0,Goal.movements.backward);
        rob.driveTrainEncoderMovement(1, 23, 20, 0, Goal.movements.ccw);
        rob.driveTrainEncoderMovement(1, 23, 20, 0, Goal.movements.right);
        rob.driveTrainEncoderMovement(1, 42, 20, 0, Goal.movements.forward);

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
        rob.driveTrainEncoderMovement(1, 7, 20, 0, Goal.movements.backward);

        // move towards wall
        // rob.driveTrainEncoderMovement(1,9,20, 0, Goal.movements.right);

        // move to the left, to align shots
        //          rob.driveTrainEncoderMovement(1,44,20,0,Goal.movements.left);
        rob.driveTrainEncoderMovement(1, 22, 20, 0, Goal.movements.left);

        // move to right behind white line
        rob.driveTrainEncoderMovement(1, 9, 20, 0, Goal.movements.forward);


        //            rob.fly.setPower(-0.72);
        //            sleep(2000);
        // 2000

        // shoot your shots

        sleep(500);
        for (int i = 0; i <= 2; i++) {
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
        rob.driveTrainEncoderMovement(1, 8, 100, 100, Goal.movements.forward);
    }
}

//shoot powershots
//          rob.lifter.setPosition(0.8);
// sleep(500);
           /* rob.driveTrainEncoderMovement(.5,5,20,0,Goal.movements.left);
            sleep(1000);
            for (int i =0; i < 4; i++) {
                while (Math.abs(rob.rightbackSense.getDistance(DistanceUnit.CM) - rob.rightfrontSense.getDistance(DistanceUnit.CM)) > .75) {
                    rob.driveTrainMovement(0.1, Goal.movements.ccw);
                    telemetry.addData("difference", "%.2f cm", Math.abs(rob.rightbackSense.getDistance(DistanceUnit.CM) - rob.rightfrontSense.getDistance(DistanceUnit.CM)));
                    telemetry.update();

                }
            }
            rob.driveTrainMovement(0, Goal.movements.forward);
            sleep(1000);
*/