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
            rob.encoderMovement(.2, 5, 20,0, Goal.movements.forward, rob.claw);

            //move to red square
            rob.driveTrainEncoderMovement(1,72,20,0,Goal.movements.forward);

            //drop wobble goal
            rob.encoderMovement(.2, 5, 20,0, Goal.movements.backward, rob.claw);

            //move to right before white line
            rob.driveTrainEncoderMovement(1,10,20,0,Goal.movements.forward);

            rob.driveTrainEncoderMovement(1,3,20,0,Goal.movements.left);

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


        }
    }
}