package com.spring.pointcut;

public class BehaviorImpl implements Behavior{

	@Override
	public void 잠자기() {
		System.out.println("잠자고 싶네...");
		
	}

	@Override
	public void 공부하기() {
		System.out.println("오지게 공부합니다.");
		
	}

	@Override
	public void 밥먹기() {
		System.out.println("배고프네 오늘 맛있었음 부리또");
		
	}

	@Override
	public void 데이트() {
		System.out.println("나 데이트 할 수 있을까???");
		
	}

	@Override
	public void 운동() {
		System.out.println("다이어트에는 운동을 해야해,,,");
		
	}

	@Override
	public void 놀기() {
		System.out.println("존나게 놀고 싶다.");
		
	}

	@Override
	public void 정신수양() {
		System.out.println("정신수양이 좀 필요해 바다 가자!!!!!!!!!");
		
	}
	
	

}
