package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Control.AutonomousControl;
import org.firstinspires.ftc.teamcode.Control.Goal;

@Autonomous(name="RealAuto)", group = "basic")

public class DecemberMeet extends AutonomousControl {
    @Override
    public void runOpMode() throws InterruptedException {

        setup(runtime, Goal.setupType.autonomous);
        telemetry.addLine("Start!");
        telemetry.update();

        if (opModeIsActive()){

            //pick up wobble goal
            rob.claw.setPower(-0.4);
            sleep(750);
            rob.claw.setPower(0);
            sleep(250);

            //move to red square
            rob.driveTrainEncoderMovement(1,10,20,0,Goal.movements.right);
            rob.driveTrainEncoderMovement(1,60,20,0,Goal.movements.forward);

            //drop wobble goal
            rob.pinch.setPosition(1);
            sleep(1000);

            //move to right before white line


            rob.driveTrainEncoderMovement(1,43,20,0,Goal.movements.backward);

            rob.driveTrainEncoderMovement(1,11,20,0,Goal.movements.left);

            rob.driveTrainEncoderMovement(0.5,23,20,0,Goal.movements.cw);



            rob.pinch.setPosition(0.8);
            sleep(500);
            rob.claw.setPower(0.4);
            sleep(900);
            rob.driveTrainEncoderMovement(0.7,15,20,0,Goal.movements.forward);

            rob.claw.setPower(-0.4);
            sleep(500);
            rob.claw.setPower(0);
            sleep(500);
            rob.pinch.setPosition(0);
            sleep(750);
            rob.claw.setPower(-0.4);
            sleep(600);
            rob.claw.setPower(0);
            sleep(250);

            rob.driveTrainEncoderMovement(1,15,20,0,Goal.movements.backward);
            rob.driveTrainEncoderMovement(0.5,23,20,0,Goal.movements.ccw);

            rob.driveTrainEncoderMovement(1,11,20,0,Goal.movements.right);
            rob.driveTrainEncoderMovement(1,43,20,0,Goal.movements.forward);

            //drop wobble goal
            rob.pinch.setPosition(1);
            sleep(1000);

            rob.driveTrainEncoderMovement(1,54,20,0,Goal.movements.left);

            //shoot powershots
         /*   rob.lifter.setPosition(0.8);
            sleep(500);
            for(int i = 0; i<=2; i++) {
                rob.fly.setPower(0.7 );
                sleep(3050);
                rob.whack.setPosition(0.6);
                sleep(900);
                rob.whack.setPosition(0);
                sleep(1000);


            }
            rob.lifter.setPosition(0);
            sleep(250);
            //move to Launch Line
            rob.driveTrainEncoderMovement(1,4,20, 0,Goal.movements.forward);

          */
        }
    }
}