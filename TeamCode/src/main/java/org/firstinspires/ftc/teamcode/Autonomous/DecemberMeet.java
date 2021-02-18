package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
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



            //move to red square
            rob.driveTrainEncoderMovement(1,66,20,0,Goal.movements.forward);

            //drop wobble goal
            rob.pinch.setPosition(0.8);
            sleep(500);
            rob.claw.setPower(0.3);
            sleep(500);
            rob.claw.setPower(0);
            sleep(250);


            //move back to pick up second wobble goal

            rob.driveTrainEncoderMovement(1,46,20,0,Goal.movements.backward);

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