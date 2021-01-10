package org.firstinspires.ftc.teamcode.Autonomous;

import com.acmerobotics.roadrunner.control.PIDFController;
import com.qualcomm.robotcore.hardware.PIDCoefficients;

public class roadrunnerTest {
    // specify coefficients/gains
    PIDCoefficients coeffs = new PIDCoefficients(kP, kI, kD);
     PIDF controller = new PIDFController(coeffs);

// specify the setpoint
controller.setTargetPosition(setpoint);

    // in each iteration of the control loop
// measure the position or output variable
// apply the correction to the input variable
    double correction = controller.update(measuredPosition);
}
