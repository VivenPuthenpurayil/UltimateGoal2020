package org.firstinspires.ftc.teamcode.Autonomous;
//hi
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Control.AutonomousControl;
import org.firstinspires.ftc.teamcode.Control.Goal;

@Autonomous(name="Test Open CV", group = "basic")
public class TestOpenCV extends AutonomousControl {

    public void runOpMode() throws InterruptedException {

        setup(runtime, Goal.setupType.openCV);
        telemetry.addLine("Start!");
        telemetry.update();

        EasyOpenCV thing = new EasyOpenCV();

    }
}