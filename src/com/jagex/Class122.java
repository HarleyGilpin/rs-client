package com.jagex;

public class Class122
{
	private CacheArchive aCacheArchive_1550;
	static int anInt1551;
	static int anInt1552;
	private CacheArchive aCacheArchive_1553;
	private Class61 aClass61_1554 = new Class61(64);
	static boolean[][] aBooleanArrayArray1555;
	static int[] anIntArray1556;
	
	public static void method1507(int i) {
		anIntArray1556 = null;
		aBooleanArrayArray1555 = null;
		if (i > -110) {
			method1507(-92);
		}
	}
	
	final CacheNode_Sub3 method1508(byte b, int i) {
		anInt1551++;
		CacheNode_Sub3 cachenode_sub3 = (CacheNode_Sub3) aClass61_1554.method607((long) i, 0);
		if (cachenode_sub3 != null) {
			return cachenode_sub3;
		}
		byte[] bs;
		if ((i ^ 0xffffffff) > -32769) {
			bs = aCacheArchive_1550.method3524(false, i, 0);
		} else {
			bs = aCacheArchive_1553.method3524(false, i & 0x7fff, 0);
		}
		int i_0_ = 10 / ((41 - b) / 47);
		cachenode_sub3 = new CacheNode_Sub3();
		if (bs != null) {
			cachenode_sub3.method2293(new Buffer(bs), false);
		}
		if ((i ^ 0xffffffff) <= -32769) {
			cachenode_sub3.method2299((byte) -18);
		}
		aClass61_1554.method601(cachenode_sub3, 25566, (long) i);
		return cachenode_sub3;
	}
	
	Class122(int i, CacheArchive cacheArchive, CacheArchive cacheArchive_1_) {
		aCacheArchive_1553 = cacheArchive_1_;
		aCacheArchive_1550 = cacheArchive;
		if (aCacheArchive_1550 != null) {
			aCacheArchive_1550.method3537(-2, 0);
		}
		if (aCacheArchive_1553 != null) {
			aCacheArchive_1553.method3537(-2, 0);
		}
	}
}
