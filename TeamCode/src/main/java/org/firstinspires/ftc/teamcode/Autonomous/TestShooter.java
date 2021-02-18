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
            sleep(5000);
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
        }


    }
}
