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

            //rob.encodeCoreHexMovement(0.75, 3, 2, 100, Goal.movements.clawIn, rob.claw);
            //rob.pinch.setPosition(0.5);
            rob.fly.setPower(-1);
            sleep(5000);

        }


    }
}