package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Control.AutonomousControl;
import org.firstinspires.ftc.teamcode.Control.Goal;

@Autonomous(name="RealDealBois", group = "basic")

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



            rob.driveTrainEncoderMovement(1,44,20,0,Goal.movements.backward);

            rob.driveTrainEncoderMovement(1,11,20,0,Goal.movements.left);

            rob.driveTrainEncoderMovement(1,22,20,0,Goal.movements.cw);

            rob.pinch.setPosition(0.8);
            sleep(500);
            rob.claw.setPower(0.4);
            sleep(700);
            rob.driveTrainEncoderMovement(0.6,17,20,0,Goal.movements.forward);

/*
            //shoot powershots
            for(int i = 0; i < 3;i++) {
                rob.driveTrainEncoderMovement(1,2,20,0,Goal.movements.left);
                rob.fly.setPower(-1);
                sleep(1000);
                rob.lifter.setPosition(.15);
                rob.whack.setPosition(.3);
                rob.fly.setPower(-1);
                sleep(3000);
                rob.whack.setPosition(0);
            }
            rob.lifter.setPosition(0);
            //move to white line
            rob.driveTrainEncoderMovement(1,4,20, 0,Goal.movements.forward);

*/
        }
    }
}