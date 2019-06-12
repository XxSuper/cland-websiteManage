package com.maiyajf.base.concurrent;

public interface LockService {

	public boolean lock(String lockKey) ;
	
	public boolean lockNoWait(String lockKey,int expireMsecs) ;
	
	public boolean lock(String lockKey, int timeoutMsecs, int expireMsecs) ;
	
	public void unLock(String lockKey);
	
    public  static final int TWENTY_MINUTES = 1200*1000;
    public  static final int TWO_HOURS = 120*60000;
    
}
