package com.jagex;
import java.math.BigInteger;

public class NPCUpdate extends Class262
{
	public static int anInt7774;
	static int anInt7767;
	private int anInt7768;
	private int anInt7769;
	private int anInt7770;
	private int anInt7771;
	private int anInt7772;
	static int[] localNPCIndices = new int[13];

	static BigInteger RSA_EXPONENT = new BigInteger("10001", 16);
	static CacheArchive npcCacheArchive;
	
	public static void clearCache() {
		npcCacheArchive = null;
		localNPCIndices = null;
		RSA_EXPONENT = null;
	}
	
	static final void updateNpcs() {
		Packet buffer = Class218.worldResponseBuffer.recievedBuffer;
		buffer.initBitAccess(107347906);
		int size = buffer.readBits(8);
		int i;
		//System.out.println("NPC update size: " + size);

		if (Node_Sub25_Sub3.NPC_UPDATE_INDEX > size) {
			for (i = size; Node_Sub25_Sub3.NPC_UPDATE_INDEX > i; i++)
				FileOnDisk.removedNPCIndices[Class270_Sub2_Sub1.removedNpcCount++] = Class54.NPC_UPDATE_INDICES[i];
				//System.out.println("NPC removed: " + Class54.NPC_UPDATE_INDICES[i]);
		}

		if (size > Node_Sub25_Sub3.NPC_UPDATE_INDEX) {
			//throw new RuntimeException("Size exceeds NPC_UPDATE_INDEX");
		}

		Node_Sub25_Sub3.NPC_UPDATE_INDEX = 0;

		for (i = 0; i < size; i++) {
			int key = Class54.NPC_UPDATE_INDICES[i];
			Npc npc = ((Node_Sub41) Class12.NPC_MAP.method1518(3512, (long) key)).aNpc7518;
			int updateRequired = buffer.readBits(1);
			//System.out.println("Updating NPC: " + key + ", updateRequired: " + updateRequired);

			if (updateRequired == 0) {
				Class54.NPC_UPDATE_INDICES[Node_Sub25_Sub3.NPC_UPDATE_INDEX++] = key;
				npc.lastUpdate = Plane.anInt3423;
			} else {
				int moveSpeed = buffer.readBits(2);
				//System.out.println("NPC moveSpeed: " + moveSpeed); // Debug line
				if (moveSpeed == 0) {
					Class54.NPC_UPDATE_INDICES[Node_Sub25_Sub3.NPC_UPDATE_INDEX++] = key;
					npc.lastUpdate = Plane.anInt3423;
					Class194_Sub1_Sub1.anIntArray9370[Node_Sub38_Sub6.anInt10132++] = key;
				} else if (moveSpeed == 1) { //Walking
					Class54.NPC_UPDATE_INDICES[Node_Sub25_Sub3.NPC_UPDATE_INDEX++] = key;
					npc.lastUpdate = Plane.anInt3423;
					int i_5_ = buffer.readBits(3);
					npc.move(1, i_5_, (byte) -111);
					int i_6_ = buffer.readBits(1);
					if (i_6_ == 1) {
						Class194_Sub1_Sub1.anIntArray9370[Node_Sub38_Sub6.anInt10132++] = key;
					}
				} else if (moveSpeed == 2) { //Running
					Class54.NPC_UPDATE_INDICES[Node_Sub25_Sub3.NPC_UPDATE_INDEX++] = key;
					npc.lastUpdate = Plane.anInt3423;
					if (buffer.readBits(1) == 1) {
						int i_7_ = buffer.readBits(3);
						npc.move(2, i_7_, (byte) -123);
						int i_8_ = buffer.readBits(3);
						npc.move(2, i_8_, (byte) -113);
					} else { //HALF WALK
						int i_9_ = buffer.readBits(3);
						npc.move(0, i_9_, (byte) -126);
					}

					int i_10 = buffer.readBits(1);
					if (i_10 == 1) {
						Class194_Sub1_Sub1.anIntArray9370[Node_Sub38_Sub6.anInt10132++] = key;
					}
				} else if (moveSpeed == 3) {
					FileOnDisk.removedNPCIndices[Class270_Sub2_Sub1.removedNpcCount++] = key;
				}
			}
		}
	}
	
	NPCUpdate(Buffer buffer) {
		super(buffer);
		anInt7772 = buffer.method2219(-130546744);
		anInt7771 = buffer.method2219(-130546744);
		anInt7770 = buffer.method2219(-130546744);
		anInt7768 = buffer.method2219(-130546744);
		anInt7769 = buffer.method2219(-130546744);
	}
	
	final void method3148(int i) {
		Class188_Sub1_Sub1.method1895(anInt7772, false, 100, (byte) 21, anInt7771, anInt7770, 100);
		if (i < -102) {
			anInt7767++;
			Node_Sub38_Sub24.method2868(3, 0, anInt7769, anInt7768);
			Class320_Sub18.aBoolean8375 = true;
		}
	}
}
