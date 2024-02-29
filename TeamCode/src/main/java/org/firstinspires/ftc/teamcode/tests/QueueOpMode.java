package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpModeManager;
import com.qualcomm.robotcore.eventloop.opmode.OpModeRegistrar;

import java.util.ArrayDeque;

public class QueueOpMode extends OpMode {
	private final ArrayDeque<OpMode> opModeQueue = new ArrayDeque<>();
	@Override
	public void init() {
		opModeQueue.add(new QueueOpMode());
	}
	
	@OpModeRegistrar
	public static void registerOpModes(OpModeManager manager) {
		manager.register("my OpMode", new QueueOpMode());
	}
	
	@Override
	public void loop() {
	
	}
}
