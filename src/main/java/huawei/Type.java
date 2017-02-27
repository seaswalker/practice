package huawei;

/**
 * 考勤的类型
 * @author skywalker
 *
 */
public enum Type {

	NORMAL {
		@Override
		public String descr() {
			return "正常：至少两次刷卡，最早的刷卡时间早于8:00（注意：8:00刷卡算迟到），且最晚的刷卡时间晚于17:30（注意：17:30刷卡算早退）";
		}
	},
	ABSENT {
		@Override
		public String descr() {
			return "旷工：至少两次刷卡，有两种情况记为旷工：a、最早的刷卡时间晚于17:30；b、最晚的刷卡时间早于8:00；";
		}
	},
	WORKLATE {
		@Override
		public String descr() {
			return "迟到：至少两次刷卡，最早的刷卡时间晚于8:00，且最晚的刷卡时间晚于17:30；";
		}
	},
	LEAVEEARLY {
		@Override
		public String descr() {
			return "早退：至少两次刷卡，最早的刷卡时间早于8:00，且最晚的刷卡时间早于17:30；";
		}
	},
	WORKLATEANDLEAVEEARLY {
		@Override
		public String descr() {
			return "既迟到又早退：至少两次刷卡，最早的刷卡时间晚于8:00，且最晚的刷卡时间早于17:30；";
		}
	},
	PUNCHABNORMAL {
		@Override
		public String descr() {
			return "刷卡异常：只有1次刷卡记录";
		}
	};
	
	/**
	 * 说明
	 */
	public abstract String descr();
	
}
