package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Control.Central;
import org.firstinspires.ftc.teamcode.Control.Goal;
import org.firstinspires.ftc.teamcode.Control.TeleOpControl;

import com.qualcomm.robotcore.util.Range;


@TeleOp(name="DriveModeFinal", group = "Main")

public class CurrentTeleop extends TeleOpControl {
    public static final double rotationSpeed = 0.4;

    @Override
    public void runOpMode() throws InterruptedException {
        boolean yToggle = false;

        setup(runtime, Goal.setupType.teleop);

        waitForStart();

        while (opModeIsActive()){
            standardGamepadData();




            if (gamepad1.y){
                yToggle = !yToggle;
            }

            if (!yToggle) {



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
                    rob.driveTrainMovement(diagonalSpeed, Goal.movements.tr);
                }else if (g(5)) {
                    rob.driveTrainMovement(diagonalSpeed, Goal.movements.tl);
                }else if (g(6)) {
                    rob.driveTrainMovement(diagonalSpeed, Goal.movements.bl);
                }else if (g(7)) {
                    rob.driveTrainMovement(diagonalSpeed, Goal.movements.br);
                }
                else if (g(8)) {
                    rob.driveTrainMovement(0.3, Goal.movements.ccw);
                } else if (g(9)) {
                    rob.driveTrainMovement(0.3, Goal.movements.cw);
                } else {
                    rob.stopDrivetrain();
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
                    rob.driveTrainMovement(0.3, Goal.movements.ccw);
                } else if (g(9)) {
                    rob.driveTrainMovement(0.3, Goal.movements.cw);
                } else {
                    rob.stopDrivetrain();
                }
            }



            //gamepad functions - lift, whack, and fly(x), wobblegoal up(y), wobblegoal down(a), wobblegoal pincher in(rb), wobblegoal pincher out(rb)


            if(gamepad1.y){
                rob.claw.setPower(-.75);
                // make the up power 1 instead of 0.2
            }
            else if(gamepad1.a){
                rob.claw.setPower(0.2);
            }
            else{
                rob.claw.setPower(0);
            }
             if(gamepad1.right_bumper){
                //adjust position depending on how thingy works
                rob.pinch.setPosition(0);
            }
            else if(gamepad1.left_bumper){
                rob.pinch.setPosition(1);
            }
             if(gamepad1.x){
                rob.fly.setPower(0.7);
                sleep(1000);
                rob.whack.setPosition(0.6);
                sleep(1000);
                rob.whack.setPosition(0);
                sleep(2000);
                rob.fly.setPower(0);
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
//check point

        }
    }
}


