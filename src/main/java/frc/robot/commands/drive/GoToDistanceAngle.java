package frc.robot.commands.drive;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drive.Drive;
import java.util.List;
import lib.holonomictrajectory.Waypoint;
import lib.utils.GeomUtils;

public class GoToDistanceAngle extends CommandBase {
  private GoToTrajectory command;
  private boolean finished = false;

  public GoToDistanceAngle(Drive drive, double distance, Rotation2d angle) {
    if (distance == 0) {
      finished = true;
    } else {
      command =
          new GoToTrajectory(
              drive,
              List.of(
                  Waypoint.fromHolonomicPose(drive.getPose()),
                  Waypoint.fromDifferentialPose(
                      drive
                          .getPose()
                          .plus(
                              GeomUtils.transformFromTranslation(
                                  new Translation2d(distance, angle))))));
    }

    addRequirements(drive);
  }

  @Override
  public void initialize() {
    command.initialize();
  }

  @Override
  public void execute() {
    command.execute();
  }

  @Override
  public void end(boolean interrupted) {
    command.end(interrupted);
  }

  @Override
  public boolean isFinished() {
    return command.isFinished() || isFinished();
  }
}
