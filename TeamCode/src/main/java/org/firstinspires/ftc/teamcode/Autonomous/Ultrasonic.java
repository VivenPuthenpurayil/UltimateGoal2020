package org.firstinspires.ftc.teamcode.Autonomous;
//hi
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Control.AutonomousControl;
import org.firstinspires.ftc.teamcode.Control.Goal;

@Autonomous(name="Ultrasonic", group = "basic")
public class Ultrasonic extends AutonomousControl {
    @Override
    public void runOpMode() throws InterruptedException {

        setup(runtime, Goal.setupType.autonomous);
        telemetry.addLine("Start!");
        telemetry.update();

        if (opModeIsActive()){
            double dist = 0;
            do{
                rob.driveTrainMovement(0.3, Goal.movements.backward);

                dist= rob.rightFront.getDistance(DistanceUnit.CM);
                telemetry.addData("cm front", "%.2f cm", dist);
                telemetry.update();

            }
            while(dist > 20 || Double.compare(dist, Double.NaN) == 0 && opModeIsActive());

        }
    }
}

