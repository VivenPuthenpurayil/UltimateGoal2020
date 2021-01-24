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

        setup(runtime, Goal.setupType.storage);
        telemetry.addLine("Start!");
        telemetry.update();

        if (opModeIsActive()){
            rob.lifter.setPosition(.84);
            rob.whack.setPosition(.3);
            //sleep(5000);
            sleep(30000);
        }


    }
}
