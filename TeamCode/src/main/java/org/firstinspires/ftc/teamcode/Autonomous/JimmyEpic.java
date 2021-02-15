package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Control.AutonomousControl;
import org.firstinspires.ftc.teamcode.Control.Goal;

@Autonomous(name="Epic", group = "basic")

public class JimmyEpic extends AutonomousControl {
    @Override

    public void runOpMode() throws InterruptedException {

        setup(runtime, Goal.setupType.autonomous);
        telemetry.addLine("Start!");
        telemetry.update();
        double angle = 0;
        double distanceBack = rob.rightBack.getDistance(DistanceUnit.CM);
        double distanceFront = rob.rightFront.getDistance(DistanceUnit.CM);

        while (opModeIsActive()) {

            // pick up wobble goal
//            rob.claw.setPower(-0.4);
//            sleep(750);
//            rob.claw.setPower(0);
//            sleep(250);

            //move to red square
            //    rob.driveTrainEncoderMovement(1,10,20,0,Goal.movements.right);
//            rob.driveTrainEncoderMovement(1,66,20,0,Goal.movements.forward);
            // previous 63

            // move to red square
            while (true) {
                if (rob.Back.getDistance((DistanceUnit.CM)) > 1000) {
                    continue;
                }
                update();
                sleep(2000);
                if (rob.Back.getDistance((DistanceUnit.CM)) < 145) {
                    rob.driveTrainMovement(.5, Goal.movements.forward);
                }
                else break;
            }

/*
            //drop wobble goal
            rob.pinch.setPosition(0.8);
            sleep(500);
            rob.claw.setPower(0.3);
            sleep(500);
            rob.claw.setPower(0);
            sleep(250);


            //move back to pick up second wobble goal
            while (true) {
                if (rob.Back.getDistance((DistanceUnit.CM)) > 1000) {
                    continue;
                }
                if (rob.Back.getDistance((DistanceUnit.CM)) > 42) {
                    rob.driveTrainMovement(.5, Goal.movements.backward);
                } else break;
            }

            rob.lifter.setPosition(.84);
            sleep(200);

            // turn to face second wobble goal
            rob.driveTrainEncoderMovement(.5, 12.75*2, 10, 10, Goal.movements.cw);

            rob.pinch.setPosition(0.8);
            sleep(500);

            // move to second wobble goal
            while (true) {
                if (rob.Back.getDistance((DistanceUnit.CM)) > 1000) {
                    continue;
                }
                if (rob.Back.getDistance((DistanceUnit.CM)) < 63) {
                    rob.driveTrainMovement(.5, Goal.movements.forward);
                } else break;
            }

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

            rob.driveTrainEncoderMovement(.5, 12.75*2, 10, 10, Goal.movements.ccw);

            while (true) {
                if (rob.rightFront.getDistance((DistanceUnit.CM)) > 1000) {
                    continue;
                }
                if (rob.rightFront.getDistance((DistanceUnit.CM)) > 23) {
                    rob.driveTrainMovement(.5, Goal.movements.right);
                } else break;
            }

            while (true) {
                if (rob.Back.getDistance((DistanceUnit.CM)) > 1000) {
                    continue;
                }
                if (rob.Back.getDistance((DistanceUnit.CM)) < 142) {
                    rob.driveTrainMovement(.5, Goal.movements.backward);
                } else break;
            }

            //drop wobble goal
            rob.pinch.setPosition(0.8);
            sleep(250);
            rob.claw.setPower(0.3);
            sleep(500);
            rob.claw.setPower(0);
            sleep(250);


 */
        }
    }

    public void update() {
        telemetry.addData("right back cm", "%.2f cm", rob.rightBack.getDistance(DistanceUnit.CM));
        telemetry.addData("right front cm", "%.2f cm", rob.rightFront.getDistance(DistanceUnit.CM));
        telemetry.addData("back", "%.2f cm", rob.Back.getDistance(DistanceUnit.CM));

//        telemetry.addData("difference", "%.2f cm", Math.abs(distanceBack - distanceFront));
//        telemetry.addData("angle", "%.2f",(Math.atan((distanceFront-distanceBack)/6.6142)*180)/(3.1415));
        telemetry.update();
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