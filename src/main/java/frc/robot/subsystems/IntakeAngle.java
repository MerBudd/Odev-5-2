package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeAngle extends SubsystemBase {
  TalonFX IntakeMotor = new TalonFX(3);
  TalonFXConfiguration MMConfigs;
  MotionMagicVoltage m_request;

  public IntakeAngle() {
    MMConfigs = new TalonFXConfiguration();
    m_request = new MotionMagicVoltage(0);

    MMConfigs.Slot0.kS = 0.25;
    MMConfigs.Slot0.kV = 0.12;
    MMConfigs.Slot0.kA = 0.01;
    MMConfigs.Slot0.kP = 4.8;
    MMConfigs.Slot0.kI = 0;
    MMConfigs.Slot0.kD = 0.1;

    MMConfigs.MotionMagic.MotionMagicCruiseVelocity = 80;
    MMConfigs.MotionMagic.MotionMagicAcceleration = 160;
    MMConfigs.MotionMagic.MotionMagicJerk = 1600;

    IntakeMotor.getConfigurator().apply(MMConfigs);
  }

  public void SetPos(double position) {
    IntakeMotor.setControl(m_request.withPosition(position));
  }
  public double GetPos() {
    return IntakeMotor.getPosition().getValueAsDouble();
  }
  
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Intake Position", GetPos());
  }
}