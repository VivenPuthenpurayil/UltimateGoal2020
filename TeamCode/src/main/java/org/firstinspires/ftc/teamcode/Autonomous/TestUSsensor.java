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

//            telemetry.addData("Raw", rob.leftSense.getRawLightDetected());
//            telemetry.update();
//            sleep(20000);
    telemetry.addData("raw ultrasonic", rob.leftSense.rawUltrasonic());
    telemetry.addData("raw optical", rob.leftSense.rawOptical());
    telemetry.addData("cm optical", "%.2f cm", rob.leftSense.cmOptical());
    telemetry.addData("cm", "%.2f cm", rob.leftSense.getDistance(DistanceUnit.CM));
    // sleep(1000);
    telemetry.update();
    sleep(2000);

        }
    }
}