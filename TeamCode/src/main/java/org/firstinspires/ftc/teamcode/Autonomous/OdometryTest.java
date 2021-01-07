
package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.teamcode.Control.AutonomousControl;
import org.firstinspires.ftc.teamcode.Control.Goal;


@Autonomous(name="Odometry Test", group = "basic")
public class OdometryTest extends AutonomousControl {
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {

        setup(runtime, Goal.setupType.autonomous);

        //setup(runtime, Crane.setupType.encoder);

        int startPosition = rob.fly.getCurrentPosition();
        int startPositionyeet = rob.collection.getCurrentPosition();
        //int startPosition = 0;

        if (opModeIsActive()){

            rob.driveTrainEncoderMovement(.3,12, 10, 0, Goal.movements.forward);

            telemetry.addData("Current Encoder Position Left: ", (rob.fly.getCurrentPosition() - startPosition));
            telemetry.addData("Current Encoder Position Right ", rob.collection.getCurrentPosition()-startPositionyeet);


            telemetry.update();
            sleep(2000);

        }
    }
}