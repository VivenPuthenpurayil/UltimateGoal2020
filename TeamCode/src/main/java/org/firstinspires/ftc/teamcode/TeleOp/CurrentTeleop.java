package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Control.Goal;
import org.firstinspires.ftc.teamcode.Control.TeleOpControl;


@TeleOp(name="vivaniskindasped", group = "Main")

public class CurrentTeleop extends TeleOpControl {
    public static final double rotationSpeed = 0.4;
    public static boolean flywheelon = false;

    @Override
    public void runOpMode() throws InterruptedException {
        boolean yToggle = false;
        boolean xToggle = false;
        boolean move_to_pos = false;
        double angle = 0;


        setup(runtime, Goal.setupType.teleop);

        waitForStart();

        while (opModeIsActive()){
            double distanceBack = rob.rightBack.getDistance(DistanceUnit.CM);
            double distanceFront = rob.rightFront.getDistance(DistanceUnit.CM);
            telemetry.addData("back", "%.2f cm", rob.Back.getDistance(DistanceUnit.CM));
            telemetry.addData("angle", "%.2f",(Math.atan((distanceFront-distanceBack)/6.6142)*180)/(3.1415));
            telemetry.update();
            standardGamepadData();

            if(gamepad2.x){
                xToggle = !xToggle;
            }

            if (gamepad1.y){
                yToggle = !yToggle;
            }

            if (!yToggle) {

                // BR - Third hole

                if (g(0)) {
                    rob.driveTrainMovement(fb, Goal.movements.forward);
                } else if (g(2)) {
                    rob.driveTrainMovement(fb, Goal.movements.backward);
                } else if (g(3)) {
                    rob.driveTrainMovement(rl, Goal.movements.right);
                } else if (g(1)) {
                    rob.driveTrainMovement(rl, Goal.movements.left);
                }
                else if (g(4)) {
                    rob.driveTrainMovement(diagonalSpeed, Goal.movements.br);
                }else if (g(5)) {
                    rob.driveTrainMovement(diagonalSpeed, Goal.movements.bl);
                }else if (g(6)) {
                    rob.driveTrainMovement(diagonalSpeed, Goal.movements.tl);
                }else if (g(7)) {
                    rob.driveTrainMovement(diagonalSpeed, Goal.movements.tr);
                }
                else if (g(8)) {
                    rob.driveTrainMovement(1, Goal.movements.ccw);
                } else if (g(9)) {
                    rob.driveTrainMovement(1, Goal.movements.cw);
                } else {
                    rob.stopDrivetrain();
                }

            }

            else {

                if (g(0)) {
                    rob.driveTrainMovement(0.5, Goal.movements.left);
                } else if (g(2)) {
                    rob.driveTrainMovement(0.5, Goal.movements.right);
                } else if (g(3)) {
                    rob.driveTrainMovement(0.3, Goal.movements.forward);
                } else if (g(1)) {
                    rob.driveTrainMovement(0.3, Goal.movements.backward);
                }
                else if (g(4)) {
                    rob.driveTrainMovement(0.3, Goal.movements.tr);
                }else if (g(5)) {
                    rob.driveTrainMovement(0.3, Goal.movements.tl);
                }else if (g(6)) {
                    rob.driveTrainMovement(0.3, Goal.movements.bl);
                }else if (g(7)) {
                    rob.driveTrainMovement(0.3, Goal.movements.br);
                }
                else if (g(8)) {
                    rob.driveTrainMovement(.3, Goal.movements.ccw);
                } else if (g(9)) {
                    rob.driveTrainMovement(.3, Goal.movements.cw);
                } else {
                    rob.stopDrivetrain();
                }
            }

            // gamepad functions - lift, whack, and fly(x), wobblegoal up(y), wobblegoal down(a),
            // wobblegoal pincher in(rb), wobblegoal pincher out(rb)


            if(gamepad2.dpad_up){
                rob.claw.setPower(-.5);
                // make the up power 1 instead of 0.2
            }
            else if(gamepad2.dpad_down){
                rob.claw.setPower(0.2);
            }
            else{
                rob.claw.setPower(0);
            }

            if(gamepad2.dpad_right){
                //adjust position depending on how thingy works
                rob.pinch.setPosition(0);
            }
            else if(gamepad2.dpad_left){
                rob.pinch.setPosition(1);
            }

            if (gamepad2.y) {
                flywheelon = true;
                move_to_pos = true;
            }

            if (gamepad2.x) {
                flywheelon = true;
            }

            if (flywheelon) {
                rob.fly.setPower(-0.73);
            }

            if(gamepad2.a) {
                rob.motorFL.setPower(0);
                rob.motorBL.setPower(0);
                rob.motorFR.setPower(0);
                rob.motorBR.setPower(0);
                sleep(250);
                rob.lifter.setPosition(.84);
                sleep(500);
                for (int i = 0; i <= 2; i++) {

                    if(gamepad2.b){
                        emergencystopDriver2();
                        break;
                    }

                    rob.fly.setPower(-0.73);
                    sleep(200);

                    if(gamepad2.b){
                        emergencystopDriver2();
                        break;
                    }

                    rob.whack.setPosition(0.5);
                    sleep(1000);

                    if(gamepad2.b){
                        emergencystopDriver2();
                        break;
                    }

                    rob.whack.setPosition(0);
                    sleep(1000);

                    if(gamepad2.b){
                        emergencystopDriver2();
                        break;
                    }
                }
                rob.fly.setPower(0);
                rob.lifter.setPosition(.98);
                sleep(200);
            }

            if(gamepad2.b){
                emergencystopDriver2();
            }

            if (gamepad1.right_trigger>.2){
                rob.collection.setPower(-1);
            }
            else if (gamepad1.left_trigger > .2){
                rob.collection.setPower(1);
            }
            else {
                rob.collection.setPower(0);
            }

            if (move_to_pos) {
                if (distanceBack > 1000 || distanceFront > 1000) {
                    continue;
                }

                angle = (Math.atan((distanceFront - distanceBack) / 6.6142) * 180) / (3.1415);
                rob.driveTrainEncoderMovement(.5, 12.75 / 90 * angle, 10, 10, Goal.movements.ccw);

                while (true) {
                    if (rob.Back.getDistance((DistanceUnit.CM)) > 1000){
                        continue;
                    }
                    if (rob.Back.getDistance((DistanceUnit.CM)) < 145){
                        rob.driveTrainMovement(0.5, Goal.movements.forward);
                    }
                    else break;
                }

                move_to_pos = false;
            }

            /*
                if(gamepad2.dpad_up){
                    rob.rightLinear.setPower(1);
                }
                else if (gamepad2.dpad_down){
                    rob.rightLinear.setPower(-0.5);
                }
                else {
                    rob.rightLinear.setPower(0);
                }

            */

            //check point`

        }
    }

    public void emergencystopDriver2() throws InterruptedException {
        flywheelon = false;
        rob.fly.setPower(0);
        sleep(200);
        rob.claw.setPower(0);
        sleep(200);
        rob.lifter.setPosition(0.98);
        sleep(200);
        rob.whack.setPosition(0);
    }

    public void emergencystopDriver1() throws InterruptedException {
        rob.motorFL.setPower(0);
        sleep(200);
        rob.motorBL.setPower(0);
        sleep(200);
        rob.motorFR.setPower(0);
        sleep(200);
        rob.motorBR.setPower(0);
        sleep(200);
        rob.collection.setPower(0);
        sleep(200);
    }

}

/*
        if(gamepad2.x) {
                rob.motorFL.setPower(0);
                rob.motorBL.setPower(0);
                rob.motorFR.setPower(0);
                rob.motorBR.setPower(0);
                sleep(250);
                rob.lifter.setPosition(.84);
                sleep(500);
                rob.fly.setPower(-0.66);
                sleep(1000);
                for (int i = 0; i <= 2; i++) {

                    if(gamepad2.b){
                        emergencystop();
                        break;
                    }

                    rob.fly.setPower(-0.8);
                    sleep(200);

                    if(gamepad2.b){
                        emergencystop();
                        break;
                    }

                    rob.whack.setPosition(0.6);
                    sleep(1000);

                    if(gamepad2.b){
                        emergencystop();
                        break;
                    }

                    rob.whack.setPosition(0);
                    sleep(1000);

                    if(gamepad2.b){
                        emergencystop();
                        break;
                    }
                }
                rob.fly.setPower(0);
                rob.lifter.setPosition(.98);
                sleep(500);
            }
 */


