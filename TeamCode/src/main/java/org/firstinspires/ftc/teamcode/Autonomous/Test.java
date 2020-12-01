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

        if (opModeIsActive()){

        //rob.collection.setPower(-.7);
        //sleep(20000);

        rob.fly.setPower(-1);
        sleep(10000);

        }
    }
}