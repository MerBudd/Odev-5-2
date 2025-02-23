// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeAngle;


public class IntakeAngleCommand extends Command {
  IntakeAngle m_intakeAngle;
  double m_position;

  public IntakeAngleCommand(IntakeAngle intakeAngle, double position) {
    this.m_intakeAngle = intakeAngle;
    this.m_position = position;
    addRequirements(intakeAngle);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    m_intakeAngle.SetPos(m_position);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
