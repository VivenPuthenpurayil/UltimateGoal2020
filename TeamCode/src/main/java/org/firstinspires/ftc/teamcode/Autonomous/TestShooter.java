package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Control.AutonomousControl;
import org.firstinspires.ftc.teamcode.Control.Goal;

@Autonomous(name="Test Shooter", group = "basic")
public class TestShooter extends AutonomousControl {
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {

        setup(runtime, Goal.setupType.autonomous);
        telemetry.addLine("Start!");
        telemetry.update();

        if (opModeIsActive()){
            rob.lifter.setPosition(.84);
            rob.fly.setPower(-1);
            sleep(5000);
            for(int i = 0; i<=3; i++) {
                rob.whack.setPosition(0.62);
                sleep(500);
                rob.whack.setPosition(0);
                sleep(1500);
            }
        }


    }
}
