/*package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Control.AutonomousControl;
import org.firstinspires.ftc.teamcode.Control.Goal;

@Autonomous(name="Test", group = "basic")
public class angleTest extends AutonomousControl {
    @Override
    public void runOpMode() throws InterruptedException {
//
        setup(runtime, Goal.setupType.autonomous);
        telemetry.addLine("Start!");
        telemetry.update();

        if (opModeIsActive()) {

            int x = 90;
            for (int i = 0; i < x; i++) {
                rob.driveTrainMovement(.5, Goal.movements.ccw);
                sleep(50);
            }
        }


    }
}


 */