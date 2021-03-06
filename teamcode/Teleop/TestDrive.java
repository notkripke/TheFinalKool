package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.GorillabotsCentral;

@Disabled
@TeleOp(group = "AAAAAAAAAA", name = "TestDrive")
public class TestDrive extends GorillabotsCentral {

    @Override
    public void runOpMode() {

        initializeComponents();

        double x = 0;
        double r = 0;
        double y = 0;

        waitForStart();


        while (opModeIsActive()) {

            // SET DRIVING STUFF ↓

            x = gamepad1.left_stick_x;
            y = -gamepad1.left_stick_y;
            r = gamepad1.right_stick_x;


           drive.go(-x,-y,-r);

           if(gamepad1.b){
               drive.resetDrivenDistance();
               gyro.resetAngle();
           }
           if(gamepad1.right_bumper){
               MoveTowRtime(180,.3,1,4000);
           }
            telemetry.addData("Distance",drive.getDrivenDistance());
            telemetry.addData("Gyro",gyro.getAngle());
            telemetry.update();


            }
            telemetry.update();
        }
    }



