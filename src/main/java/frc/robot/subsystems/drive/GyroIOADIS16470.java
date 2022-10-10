package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj.ADIS16470_IMU;

public class GyroIOADIS16470 implements GyroIO {
    private final ADIS16470_IMU gyro;

    public GyroIOADIS16470() {
        this.gyro = new ADIS16470_IMU();
        gyro.setYawAxis(ADIS16470_IMU.IMUAxis.kY);
        gyro.calibrate();
        gyro.reset();
    }

    @Override
    public void updateInputs(GyroIOInputs inputs) {
        inputs.connected = true;
        inputs.angle = gyro.getAngle();
        inputs.rate = gyro.getRate();
    }
}
