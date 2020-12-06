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

        rob.lifter.setPosition(.5);
        //rob.collection.setPower(-1);
        //sleep(20000);
        //rob.fly.setPower(-1);
        //sleep(5000);
       // rob.whack.setPosition(.6);
        //sleep(10000);


        }
    }
}