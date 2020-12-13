package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Control.AutonomousControl;
import org.firstinspires.ftc.teamcode.Control.Goal;

@Autonomous(name="Test", group = "basic")
public class Test extends AutonomousControl {
    @Override
    public void runOpMode() throws InterruptedException {
//hi
        setup(runtime, Goal.setupType.autonomous);
        telemetry.addLine("Start!");
        telemetry.update();

        if (opModeIsActive()) {

            telemetry.addData("Raw", rob.leftSense.getRawLightDetected());
            telemetry.update();

        }

//        if (opModeIsActive()){
//            for(int i = 0; i<=2; i++) {
//                rob.fly.setPower(0.7 );
//                sleep(3050);
//                rob.whack.setPosition(0.6);
//                sleep(900);
//                rob.whack.setPosition(0);
//                sleep(1000);
//            }
//        }
    }
}