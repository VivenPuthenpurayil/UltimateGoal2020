package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
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

import java.util.Locale;

@Autonomous(name="AngleTest", group = "basic")
public class angleTest extends AutonomousControl {

    //----------------------------------------------------------------------------------------------
    // State
    //----------------------------------------------------------------------------------------------

    // The IMU sensor object
    BNO055IMU imu;

    // State used for updating telemetry
    Orientation angles;
    Acceleration gravity;
//f
    //----------------------------------------------------------------------------------------------
    // Main logic
    //-------------

    @Override
    public void runOpMode() throws InterruptedException {

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
        parameters.loggingEnabled      = true;
        parameters.loggingTag          = "IMU";

        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);

        // Set up our telemetry dashboard
        composeTelemetry();

        // Wait until we're told to go
        waitForStart();

        setup(runtime, Goal.setupType.drivetrain_system);
        telemetry.addLine("Start!");
        telemetry.update();
//1 encoder = 3.91304

        rob.driveTrainEncoderMovement(.5,12, 10,10,Goal.movements.ccw);

        if (opModeIsActive()) {

            for (int i=0; i<2; i++) {
                String angle = formatAngle(angles.angleUnit, angles.firstAngle);
                telemetry.addData("angle", angle);
                telemetry.update();
                sleep(2000);
                double a = Double.parseDouble(angle);
                AngleToEncoder(a);

            }

            sleep(2000);

            rob.driveTrainEncoderMovement(.5,-30, 10,10,Goal.movements.ccw);

            for (int i=0; i<2; i++) {
                String angle = formatAngle(angles.angleUnit, angles.firstAngle);
                telemetry.addData("angle", angle);
                telemetry.update();
                sleep(2000);
                double a = Double.parseDouble(angle);
                AngleToEncoder(a);

            }

        }


    }

    public void AngleToEncoder(double angle) throws InterruptedException {
        rob.driveTrainEncoderMovement(.5,23.0/90 * angle, 10,10,Goal.movements.ccw);
    }
    String formatAngle(AngleUnit angleUnit, double angle) {
        return formatDegrees(AngleUnit.DEGREES.fromUnit(angleUnit, angle));
    }

    String formatDegrees(double degrees){
        return String.format(Locale.getDefault(), "%.1f", AngleUnit.DEGREES.normalize(degrees));
    }

    void composeTelemetry() {

        // At the beginning of each telemetry update, grab a bunch of data
        // from the IMU that we will then display in separate lines.
        telemetry.addAction(new Runnable() {
            @Override
            public void run() {
                // Acquiring the angles is relatively expensive; we don't want
                // to do that in each of the three items that need that info, as that's
                // three times the necessary expense.
                angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
                gravity = imu.getGravity();
            }
        });


        telemetry.addLine()
                .addData("heading", new Func<String>() {
                    @Override
                    public String value() {
                        return formatAngle(angles.angleUnit, angles.firstAngle);
                    }
                });
    }

}


