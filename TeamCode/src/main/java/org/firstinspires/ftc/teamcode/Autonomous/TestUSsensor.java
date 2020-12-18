package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Control.AutonomousControl;
import org.firstinspires.ftc.teamcode.Control.Goal;

@Autonomous(name="Ultra sonic test", group = "basic")
public class TestUSsensor extends AutonomousControl {
    @Override
    public void runOpMode() throws InterruptedException {
//hi
        setup(runtime, Goal.setupType.autonomous);
        telemetry.addLine("Start!");
        telemetry.update();

        while (opModeIsActive()){
            while(rob.rightbackSense.getDistance(DistanceUnit.CM) != rob.rightfrontSense.getDistance(DistanceUnit.CM)){
                if(rob.rightbackSense.getDistance(DistanceUnit.CM) > rob.rightfrontSense.getDistance(DistanceUnit.CM)){
                    rob.driveTrainMovement(0.7, Goal.movements.left);
                }
                else if(rob.rightbackSense.getDistance(DistanceUnit.CM) < rob.rightfrontSense.getDistance(DistanceUnit.CM)){
                    rob.driveTrainMovement(0.7, Goal.movements.right);
                }
            }

////            telemetry.addData("Raw", rob.leftSense.getRawLightDetected());
////            telemetry.update();
////            sleep(20000);
//            //telemetry.addData("status", rob.leftSense.status());
//            telemetry.addData("left cm", "%.2f cm", rob.leftSense.getDistance(DistanceUnit.CM));
//          //  telemetry.addData("right cm", "%.2f cm", rob.frontSense.getDistance(DistanceUnit.CM));
//            telemetry.addData("right front cm", "%.2f cm", rob.rightfrontSense.getDistance(DistanceUnit.CM));
//            telemetry.addData("right back cm", "%.2f cm", rob.rightbackSense.getDistance(DistanceUnit.CM));
//            // sleep(1000);
//            telemetry.update();
//            sleep(30);

        }
    }
}

