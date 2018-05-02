/**
 * 
 */
package com.jeeplus.modules.tools.utils;

/**
 * @author MikeSun
 *
 */
public class EnumUtils {

	/**
	 * 内儿科
	 */
	public static String[] NEK = new String[] { "dzzqgxt", "fgny", "smhxjhy", "ychxj", "wchxj", "qwzqgj", "zdptj",
			"hxshzly", "whq", "xldpljcy", "ydsb", "xtfxy", "dznjxt", "ydpb", "dtxdtj", "dtxyjcy", "ccy", "lsqbq",
			"spndjcxt", "yfdwy", "jldpl", "xytxj", "xlj", "zdfmtxj", "sclzz", "clc", "zsb", "syb", "nkjqxzz", "nkjcgj",
			"nkjclq", "nkjwjbgk", "yefsqjt", "xsejphh", "dgnnx", "wlhhcly", "qtqzm" };

	/**
	 * 感染性疾病科
	 */
	public static String[] GRXJBK = new String[] { "yzjcnkj", "cdslj", "gbzly", "qtqzm" };

	/**
	 * * 放射科、超声科、心电图科
	 */
	public static String[] FSKCSKXDTK = new String[] { "xdtj", "dtxdtj", "hbcsbzdy", "tscscsbzdy", "bxcscsbzdy",
			"hcgzcxsbmri", "szjyxgzyjdsa", "xsxjsjtcsysbct", "jsjxsxjcr", "szhxsxjdr", "cwxsxj", "mnxsxj", "rxxsxj",
			"xxgmdy", "ydxsxj", "qtqzm" };

	/**
	 * 药剂科
	 */
	public static String[] YJK = new String[] { "znfyj", "zdxyj", "zdfbj", "zyjyj", "zybzj", "zyqpj", "zycyj", "zyhgj",
			"zyfsj", "yplcg", "qtqzm" };

	/**
	 * 眼科、耳鼻咽喉科
	 */

	public static String[] YKEBHK = new String[] { "ydygzyy", "ykssxwj", "gxxgdcsmy", "ykabcszdy", "syj", "csrhy",
			"ydzxj", "yqjzxxt", "dnygy", "fjcsyyj", "smjjydj", "lhdxwj", "jmchy", "ebhnkjxt", "tjyfdwy", "ebhzhzlt",
			"szkzefxy", "dcty", "kshj", "qtqzm" };

	/**
	 * 中医科
	 */
	public static String[] ZYK = new String[] { "mzy", "szy", "zykmzy", "jljcy", "jlcjy", "zykwzy", "zykzlj", "zykgly",
			"xzzly", "wbzjzly", "jgxwzly", "qtqzm" };

	/**
	 * 住院部
	 */

	public static String[] ZYB = new String[] { "xdtj", "dtxyjcy", "dtxdtj", "dtxtjcxt", "zyjhxt", "dcsjhy", "bfch",
			"ccy", "dgnbc", "qtqzm" };

	/**
	 * 3.4 公共卫生部
	 */
	public static String[] GGWSB = new String[] { "sctzj", "ettzc", "scxesfsy", "tljcy", "fgny", "rtcffxy", "slb",
			"yylcldx", "lcb", "hxq", "fkzlc", "qtqzm" };

	/**
	 * 3.5 计划生育部
	 */
	public static String[] JHSYB = new String[] { "lcxyq", "ksrlssxt", "fkzlc", "qtqzm" };
	
	/**
	 * 4.1信息化系统建设情况
	 */
	
	public static String[] XXHJS =new  String[] { "yyxxxthis", "lcxxxtcis", "dzblxtemr",  "dzjkdaxtehr", "sysxxxtlis", "yxyxcdytxxtpscs","ycylxttis", "qtqzm" };

	
	
	
	
	
	
	
	
	
	public enum FJPZ {
		MJZYF("门急诊用房", 1), 
		YJYF("医技（含手术）用房", 2), 
		ZYYF("住院用房", 3), 
		GGWSYF("公共卫生用房", 4), 
		JHSYYF("计划生育用房",5), 
		ZNGLYF("职能管理用房", 6), 
		ZGSHYF("职工生活用房", 7), 
		SWCD("室外场地", 8);

		// 成员变量
		private String name;
		private int index;

		// 构造方法
		private FJPZ(String name, int index) {
			this.name = name;
			this.index = index;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		// 普通方法
		public static String getName(int index) {
			for (FJPZ c : FJPZ.values()) {
				if (c.getIndex() == index) {
					return c.name;
				}
			}
			return null;
		}

		public static FJPZ getjbzlEnumbyindex(int index) {
			for (FJPZ jz : FJPZ.values()) {
				if (String.valueOf(index).equals(String.valueOf(jz.getIndex()))) {
					return jz;
				}
			}
			return null;

		}

	}

	public enum IRONFOEMERGENCYROOM {
		DCSJHY("多参数监护仪", 1001), 
		CPXLY("床旁血滤仪", 1002), 
		YCHXJ("有创呼吸机", 1003), 
		YZHXJ("转运呼吸机", 1004), 
		WCHXJ("无创呼吸机",1005), 
		ZDPTJ("振动排痰机", 1006), 
		XDTJ("心电图机", 1007), 
		XFFSJ("心肺复苏机", 1008), 
		QCY("清创仪",1009), 
		XWZQGJ("纤维支气管镜", 10011), 
		CZY("除颤仪", 10012), 
		LSQBQ("临时起搏器", 10013), 
		XWJ("洗胃机",10014), 
		QJJHXJHC("抢救监护型救护车", 10015), 
		KSHJ("可视喉镜", 10016), 
		QTQZM("其它（请注明）", 10017);

		// 成员变量
		private String name;
		private int index;

		// 构造方法
		private IRONFOEMERGENCYROOM(String name, int index) {
			this.name = name;
			this.index = index;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		// 普通方法
		public static String getName(int index) {
			for (IRONFOEMERGENCYROOM c : IRONFOEMERGENCYROOM.values()) {
				if (c.getIndex() == index) {
					return c.name;
				}
			}
			return null;
		}

		public static IRONFOEMERGENCYROOM getEnumbyname(String name) {
			for (IRONFOEMERGENCYROOM jz : IRONFOEMERGENCYROOM.values()) {
				if (String.valueOf(name) == String.valueOf(jz.getName())
						|| String.valueOf(name).equals(String.valueOf(jz.getName()))) {
					return jz;
				}

			}

			return null;
		}

		public static IRONFOEMERGENCYROOM getEnumbyindex(int index) {
			for (IRONFOEMERGENCYROOM jz : IRONFOEMERGENCYROOM.values()) {
				if (String.valueOf(index).equals(String.valueOf(jz.getIndex()))) {
					return jz;
				}
			}
			return null;

		}

	}

	public enum IRONFOPFK {

		JGZLY("激光治疗仪", 32001), 
		HGZLY("红光治疗仪", 32002), 
		LGZLY("蓝光治疗仪", 32003), 
		ZWZLY("紫外治疗仪", 32004), 
		YTLLQ("液氮冷疗器",32005), 
		QTQZM("其它（请注明）", 32006);

		// 成员变量
		private String name;
		private int index;

		// 构造方法
		private IRONFOPFK(String name, int index) {
			this.name = name;
			this.index = index;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		// 普通方法
		public static String getName(int index) {
			for (IRONFOPFK c : IRONFOPFK.values()) {
				if (c.getIndex() == index) {
					return c.name;
				}
			}
			return null;
		}

		public static IRONFOPFK getEnumbyname(String name) {
			for (IRONFOPFK jz : IRONFOPFK.values()) {
				if (String.valueOf(name) == String.valueOf(jz.getName())
						|| String.valueOf(name).equals(String.valueOf(jz.getName()))) {
					return jz;
				}

			}

			return null;
		}

		public static IRONFOPFK getEnumbyindex(int index) {
			for (IRONFOPFK jz : IRONFOPFK.values()) {
				if (String.valueOf(index).equals(String.valueOf(jz.getIndex()))) {
					return jz;
				}
			}
			return null;

		}

	}

	public enum IRONFOKQK {

		ZXSCT("锥形束CT", 33001), 
		YPCXXT("牙片成像系统", 33002), 
		KQNKJXT("口腔内窥镜系统", 33003), 
		YKZHZLT("牙科综合治疗台", 33004), 
		NTGGYXT("镍钛根管预备系统", 33005), 
		RYJGGXT("热牙胶根管系统", 33006), 
		BJYM("拌机印模", 33007), 
		KQSZYMY("口腔数字印模仪",33008), 
		YKSJ("牙科手机", 33009), 
		SJQXZYJ("手机清洗注油机", 33011), 
		PSJYJ("喷沙洁牙机", 33012), 
		KQYMJ("口腔压膜机",33013), 
		JGDMJ("技工打磨机", 33014), 
		JGT("技工台", 33015), 
		QTQZM("其它（请注明）", 33016);

		// 成员变量
		private String name;
		private int index;

		// 构造方法
		private IRONFOKQK(String name, int index) {
			this.name = name;
			this.index = index;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		// 普通方法
		public static String getName(int index) {
			for (IRONFOKQK c : IRONFOKQK.values()) {
				if (c.getIndex() == index) {
					return c.name;
				}
			}
			return null;
		}

		public static IRONFOKQK getEnumbyname(String name) {
			for (IRONFOKQK jz : IRONFOKQK.values()) {
				if (String.valueOf(name) == String.valueOf(jz.getName())
						|| String.valueOf(name).equals(String.valueOf(jz.getName()))) {
					return jz;
				}

			}

			return null;
		}

		public static IRONFOKQK getEnumbyindex(int index) {
			for (IRONFOKQK jz : IRONFOKQK.values()) {
				if (String.valueOf(index).equals(String.valueOf(jz.getIndex()))) {
					return jz;
				}
			}
			return null;

		}

		// public static Object values() {
		// // TODO Auto-generated method stub
		// return null;
		// }

	}

	public enum IRONFOJYK {

		QZDSHFXY("全自动生化分析仪", 34001), 
		HXFGMYFXY("化学发光免疫分析仪", 34002), 
		LSXBY("流式细胞仪", 34003), 
		XXBFXY("血细胞分析仪",34004), 
		XYFXY("血凝分析仪", 34005), 
		XQFXY("血气分析仪", 34006), 
		XXJDY("血型鉴定仪", 34007), 
		GSLDLXJ("高速冷冻离心机",34008), 
		YMJDXPYY("药敏鉴定血培养仪", 34009), 
		NCZFXY("尿沉渣分析仪", 34011), 
		PCRY("PCR仪", 34012), 
		EYHTPYX("二氧化碳培养箱", 34013), 
		MBFXY("酶标分析仪", 34014), 
		XBJ("洗板机", 34015), 
		CMCFYDBFXY("超敏C反应蛋白分析仪",34016), 
		THXHDBFXY("糖化血红蛋白分析仪", 34017), 
		DWBX("低温冰箱", 34018), 
		NYFXY("尿液分析仪",34019), 
		SWXWJ("生物显微镜", 34021), 
		SWAQG("生物安全柜", 34022), 
		STYZ("渗透压计",34023), 
		LXJ("离心机", 34024), 
		XKBX("血库冰箱",34025), 
		ZTXYHSXT("自体血液回输系统", 34026), 
		XYFZY("血液辐照仪",34027), 
		BDMHSB("病毒灭活设备", 34028), 
		XYRHX("血液融化箱",34029), 
		QTQZM("其它（请注明）", 34031);

		// 成员变量
		private String name;
		private int index;

		// 构造方法
		private IRONFOJYK(String name, int index) {
			this.name = name;
			this.index = index;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		// 普通方法
		public static String getName(int index) {
			for (IRONFOJYK c : IRONFOJYK.values()) {
				if (c.getIndex() == index) {
					return c.name;
				}
			}
			return null;
		}

		public static IRONFOJYK getEnumbyname(String name) {
			for (IRONFOJYK jz : IRONFOJYK.values()) {
				if (String.valueOf(name) == String.valueOf(jz.getName())
						|| String.valueOf(name).equals(String.valueOf(jz.getName()))) {
					return jz;
				}

			}

			return null;
		}

		public static IRONFOKQK getEnumbyindex(int index) {
			for (IRONFOKQK jz : IRONFOKQK.values()) {
				if (String.valueOf(index).equals(String.valueOf(jz.getIndex()))) {
					return jz;
				}
			}
			return null;

		}

	}

	public enum IRONFOWKFCK {
		GZZLY("光子治疗仪"), 
		QCY("清创仪"), 
		KQYLBZLLXT("空气压力波治疗系统(预防血栓)"), 
		TWCSSSJ("体外超声碎石机"), 
		JGSSJ("激光碎石机"), 
		NDLXFXXT("尿动力学分析系统"), 
		PGJ("膀胱镜"), 
		GKDLXT("骨科动力系统"), 
		DGNQYC("多功能牵引床"), 
		GQJXT("宫腔镜系统"), 
		BCXBJCTCT("薄层细胞检测TCT"), 
		TXJHXT("胎心监护系统"), 
		DZYDJ("电子阴道镜"), 
		FKZLC("妇科诊疗床"), 
		QTQZM("其它（请注明）");

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		// 构造方法
		private IRONFOWKFCK(String name) {
			this.name = name;

		}

		public static IRONFOWKFCK getEnumbyname(String name) {
			for (IRONFOWKFCK jz : IRONFOWKFCK.values()) {
				if (String.valueOf(name) == String.valueOf(jz.getName())
						|| String.valueOf(name).equals(String.valueOf(jz.getName()))) {
					return jz;
				}

			}
			return null;
		}
	}

	/**
	 * 手术室
	 * 
	 * @author MikeSun
	 *
	 */
	public enum IRONFOWKSSS {
		CXBXXJ("C型臂X线机"), 
		FQJXT("腹腔镜系统"), 
		GQJXT("宫腔镜系统"), 
		CSD("超声刀"), 
		SSXWJ("手术显微镜"), 
		XQFXY("血气分析仪"), 
		CSBZDY("超声波诊断仪"), 
		KSHJ("可视喉镜"), 
		DCSJHY("多参数监护仪"), 
		SSDT("手术吊塔"), 
		ZHSSC("综合手术床"), 
		WYD("无影灯"), 
		GPDD("高频电刀"), 
		YZHXJ("转运呼吸机"), 
		CCY("除颤仪"), 
		SSDJC("手术对接车"), 
		CC("产床"), 
		MZSDJCY("麻醉深度检测仪"), 
		HXMZJ("呼吸麻醉机"), 
		MZBB("麻醉靶泵"), 
		QTQZM("其它（请注明）");

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		// 构造方法
		private IRONFOWKSSS(String name) {
			this.name = name;

		}

		public static IRONFOWKSSS getEnumbyname(String name) {
			for (IRONFOWKSSS jz : IRONFOWKSSS.values()) {
				if (String.valueOf(name) == String.valueOf(jz.getName())
						|| String.valueOf(name).equals(String.valueOf(jz.getName()))) {
					return jz;
				}

			}
			return null;
		}
	}

	/**
	 * 康复室
	 * 
	 * @author MikeSun
	 *
	 */
	public enum IRONFOKFS {
		// gnwdnzly_sbmc---光能微电脑治疗仪
		GNWDNZLY("光能微电脑治疗仪"),
		// hwzly_sbmc---红外治疗仪
		HWZLY("红外治疗仪"),
		// sjxtkfzlgzz_sbmc---神经系统康复治疗工作站
		SJXTKFZLGZZ("神经系统康复治疗工作站"),
		// mcczly_sbmc---脉冲磁治疗仪
		MCCZLY("脉冲磁治疗仪"),
		// ddqlc_sbmc---电动起立床
		DDQLC("电动起立床"),
		// qlc_sbmc--站立床
		QLC("站立床"),
		// ddqyc_sbmc--电动牵引床
		DDQYC("电动牵引床"),
		// csbzly_sbmc--超声波治疗仪
		CSBZLY("超声波治疗仪"),
		// nxhzhzlj_sbmc--脑循环综合治疗机
		NXHZHZLJ("脑循环综合治疗机"),
		// kqylbzlxt_sbmc---空气压力波治疗系统(水肿治疗)
		KQYLBZLXT("空气压力波治疗系统(水肿治疗)"),
		// dnzpzly_sbmc---电脑中频治疗仪
		DNZPZLY("电脑中频治疗仪"),
		// dpzly_sbmc---低频治疗仪
		DPZLY("低频治疗仪"),
		// llzyxwbj_sbmc---理疗专用型微波机
		LLZYXWBJ("理疗专用型微波机"),
		// gyyc_sbmc---高压氧仓
		GYYC("高压氧仓"),
		// phxlxt_sbmc---平衡训练系统
		PHXLXT("平衡训练系统"),
		// qjjhsb_sbmc--情景交互设备
		QJJHSB("情景交互设备"), QTQZM("其它（请注明）");

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		// 构造方法
		private IRONFOKFS(String name) {
			this.name = name;

		}

		public static IRONFOKFS getEnumbyname(String name) {
			for (IRONFOKFS jz : IRONFOKFS.values()) {
				if (String.valueOf(name) == String.valueOf(jz.getName())
						|| String.valueOf(name).equals(String.valueOf(jz.getName()))) {
					return jz;
				}

			}
			return null;
		}
	}

	/**
	 * 消毒供应室
	 * 
	 * @author MikeSun
	 *
	 */
	public enum IRONFOXDGYS {
		// 环氧乙烷灭菌器---hyywmjq_sbmc
		HYYWMJQ("环氧乙烷灭菌器"),
		// 低温等离子灭菌器---dwdlzmjq_sbmc
		DWDLZMJQ("低温等离子灭菌器"),
		// 压力蒸汽灭菌器---ylzqmjq_sbmc
		YLZQMJQ("压力蒸汽灭菌器"),
		// 全自动清洗消毒机--qzdqxxdj_sbmc
		QZDQXXDJ("全自动清洗消毒机"),
		// 超声清洗机---csqxj_sbmc
		CSQXJ("超声清洗机"),
		// 水处理装置--sclzz_sbmc
		SCLZZ("水处理装置"),
		// 封口机---fkj_sbmc
		FKJ("封口机"),
		// 快速阅读器---ksydq_sbmc
		KSYDQ("快速阅读器"), QTQZM("其它（请注明）");

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		// 构造方法
		private IRONFOXDGYS(String name) {
			this.name = name;

		}

		public static IRONFOXDGYS getEnumbyname(String name) {
			for (IRONFOXDGYS jz : IRONFOXDGYS.values()) {
				if (String.valueOf(name) == String.valueOf(jz.getName())
						|| String.valueOf(name).equals(String.valueOf(jz.getName()))) {
					return jz;
				}

			}
			return null;
		}
	}

	/**
	 * 感染性疾病科
	 * 
	 * @author MikeSun
	 *
	 */
	public enum IRONFOGRXJBK {
		// yzjcnkj
		YZJCNKJ("乙状结肠内窥镜"),
		// cdslj---肠道水疗机
		CDSLJ("肠道水疗机"),
		// gbzly---肝病治疗仪
		GBZLY("肝病治疗仪"), QTQZM("其它（请注明）");

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		// 构造方法
		private IRONFOGRXJBK(String name) {
			this.name = name;

		}

		public static IRONFOGRXJBK getEnumbyname(String name) {
			for (IRONFOGRXJBK jz : IRONFOGRXJBK.values()) {
				if (String.valueOf(name) == String.valueOf(jz.getName())
						|| String.valueOf(name).equals(String.valueOf(jz.getName()))) {
					return jz;
				}

			}
			return null;
		}
	}

	/**
	 * 内儿科
	 * 
	 * @author MikeSun
	 *
	 */
	public enum IRONFONEK {
		// dzzqgxt---电子支气管系统
		DZZQGXT("电子支气管系统"),
		// fgny---肺功能仪
		FGNY("肺功能仪"),
		// smhxjhy---睡眠呼吸监护仪
		SMHXJHY("睡眠呼吸监护仪"),
		// ychxj---有创呼吸机
		YCHXJ("有创呼吸机"),
		// wchxj---无创呼吸机
		WCHXJ("无创呼吸机"),
		// qwzqgj---纤维支气管镜
		QWZQGJ("纤维支气管镜"),
		//
		// zdptj---振动排痰机
		ZDPTJ("振动排痰机"),
		// hxshzly---呼吸湿化治疗仪
		HXSHZLY("呼吸湿化治疗仪"),
		// whq---雾化器
		WHQ("雾化器"),
		// xldpljcy---血流多普勒检测仪
		XLDPLJCY("血流多普勒检测仪"),
		// ydsb---胰岛素泵
		YDSB("胰岛素泵"), XTFXY("血糖分析仪"),
		// dznjxt---电子内镜系统
		DZNJXT("电子内镜系统"),
		// ydpb---运动平板
		YDPB("运动平板"),
		// dtxdtj---动态心电图机
		DTXDTJ("动态心电图机"),
		// dtxyjcy---动态血压监测仪
		DTXYJCY("动态血压监测仪"),
		// ccy---除颤仪
		CCY("除颤仪"),
		// lsqbq---临时起搏器
		LSQBQ("临时起搏器"),
		// spndjcxt---视频脑电监测系统
		SPNDJCXT("视频脑电监测系统"),
		// yfdwy---诱发电位仪
		YFDWY("诱发电位仪"),
		// jldpl---经颅多普勒
		JLDPL("经颅多普勒"),
		// xytxj---血液透析机
		XYTXJ("血液透析机"),
		// xlj---血滤机
		XLJ("血滤机"),
		// zdfmtxj---自动腹膜透析机
		ZDFMTXJ("自动腹膜透析机"),
		// sclzz---水处理装置
		SCLZZ("水处理装置"),
		// clc---层流床
		CLC("层流床"),
		// zsb---注射泵
		ZSB("注射泵"),
		// syb---输液泵
		SYB("输液泵"),
		// nkjqxzz---内窥镜清洗装置
		NKJQXZZ("内窥镜清洗装置"),
		// nkjcgj---内窥镜吹干机
		NKJCGJ("内窥镜吹干机"),
		// nkjclq---内窥镜侧漏器
		NKJCLQ("内窥镜侧漏器"),
		// nkjwjbgk---内窥镜无菌保管柜
		NKJWJBGK("内窥镜无菌保管柜"),
		// yefsqjt---婴儿辐射抢救台
		YEFSQJT("婴儿辐射抢救台"),
		// xsejphh---新生儿经皮黄疸
		XSEJPHH("新生儿经皮黄疸"),
		// dgnnx---多功能暖箱
		DGNNX("多功能暖箱"),
		// wlhhcly---微量黄疸测量仪
		WLHHCLY("微量黄疸测量仪"),
		// SYB("输液泵"),
		// SYB("输液泵"),
		// SYB("输液泵"),
		// SYB("输液泵"),

		QTQZM("其它（请注明）");

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		// 构造方法
		private IRONFONEK(String name) {
			this.name = name;

		}

		public static IRONFONEK getEnumbyname(String name) {
			for (IRONFONEK jz : IRONFONEK.values()) {
				if (String.valueOf(name) == String.valueOf(jz.getName())
						|| String.valueOf(name).equals(String.valueOf(jz.getName()))) {
					return jz;
				}

			}
			return null;
		}
	}

	/**
	 * 放射科、超声科、心电图科
	 * 
	 * @author MikeSun
	 *
	 */
	public enum IRONFOFSKCSKXDTK {
		// xdtj---心电图机
		XDTJ("心电图机"),
		// dtxdtj---动态心电图机
		DTXDTJ("动态心电图机"),
		// hbcsbzdy---黑白超声波诊断仪
		HBCSBZDY("黑白超声波诊断仪"),
		// tscscsbzdy---台式彩色超声波诊断仪
		TSCSCSBZDY("台式彩色超声波诊断仪"),
		// bxcscsbzdy---便携彩色超声波诊断仪
		BXCSCSBZDY("便携彩色超声波诊断仪"),
		// hcgzcxsbmri---核磁共振成像设备MRI
		HCGZCXSBMRI("核磁共振成像设备MRI"), SZJYXGZYJDSA("数字减影血管造影机DSA"),
		// xsxjsjtcsysbct---X射线计算机体层摄影设备CT
		XDXJSJTCSYSBCT("X射线计算机体层摄影设备CT"),
		// jsjxsxjcr---计算机X射线机CR
		JSJXSXJCR("计算机X射线机CR"),
		// szhxsxjdr---数字化X射线机DR
		SZHXSXJDR("数字化X射线机DR"),
		// cwxsxj--胃肠 X射线机
		CWXSXJ("胃肠 X射线机"),
		// mnxsxj---泌尿X射线机
		MNXSXJ("泌尿X射线机"),
		// rxxsxj---乳腺X射线机
		RXXSXJ("乳腺X射线机"),
		// xxgmdy--X线骨密度仪
		XXGMDY("X线骨密度仪"),
		// ydxsxj---移动X射线机
		YDXSXJ("移动X射线机"), QTQZM("其它（请注明）");

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		// 构造方法
		private IRONFOFSKCSKXDTK(String name) {
			this.name = name;

		}

		public static IRONFOFSKCSKXDTK getEnumbyname(String name) {
			for (IRONFOFSKCSKXDTK jz : IRONFOFSKCSKXDTK.values()) {
				if (String.valueOf(name) == String.valueOf(jz.getName())
						|| String.valueOf(name).equals(String.valueOf(jz.getName()))) {
					return jz;
				}

			}
			return null;
		}
	}

	/**
	 * 药剂科
	 * 
	 * @author MikeSun
	 *
	 */
	public enum IRONFOYJK {
		// znfyj---智能发药机
		ZNFYJ("智能发药机"),
		// zdxyj---自动剥药机
		ZDXYJ("自动剥药机"),
		// zdfbj---自动分包机
		ZDFBJ("自动分包机"),
		// zyjyj---中药煎药机
		ZYJYJ("中药煎药机"),
		// zybzj---中药包装机
		ZYBZJ("中药包装机"),
		// zyqpj---中药切片机
		ZYQPJ("中药切片机"),
		// zycyj---中药炒药机
		ZYCYJ("中药炒药机"),
		// zyhgj---中药烘干机
		ZYHGJ("中药烘干机"),
		// zyfsj---中药粉碎机
		ZYFSJ("中药粉碎机"),
		// yplcg---药品冷藏柜
		YPLCG("药品冷藏柜"), QTQZM("其它（请注明）");

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		// 构造方法
		private IRONFOYJK(String name) {
			this.name = name;

		}

		public static IRONFOYJK getEnumbyname(String name) {
			for (IRONFOYJK jz : IRONFOYJK.values()) {
				if (String.valueOf(name) == String.valueOf(jz.getName())
						|| String.valueOf(name).equals(String.valueOf(jz.getName()))) {
					return jz;
				}

			}
			return null;
		}
	}

	/**
	 ** 眼科、耳鼻咽喉科
	 * 
	 * @author MikeSun
	 *
	 */
	public enum IRONFOYKEBHK {
		// ydygzyy---眼底荧光造影仪
		YDYGZYY("眼底荧光造影仪"),
		// ykssxwj---眼科手术显微镜
		YKSSXWJ("眼科手术显微镜"),
		// gxxgdcsmy---光学相干断层扫描仪
		GXXGDCSMY("光学相干断层扫描仪"),
		// ykabcszdy---眼科A/B超声诊断仪
		YKABCSZDY("眼科A/B超声诊断仪"),
		// syj---视野计
		SYJ("视野计"),
		// csrhy---超声乳化仪
		CSRHY("超声乳化仪"),
		// ydzxj---眼底照相机
		YDZXJ("眼底照相机"),
		// yqjzxxt---眼前节照相系统
		YQJZXXT("眼前节照相系统"),
		// dnygy---电脑验光仪
		DNYGY("电脑验光仪"),
		// fjcsyyj---非接触式眼压计
		FJCSYYJ("非接触式眼压计"),
		// smjjydj---双目间接眼底镜
		SMJJYDJ("双目间接眼底镜"),
		// lhdxwj---裂隙灯显微镜
		LHDXWJ("裂隙灯显微镜"),
		// jmchy---角膜测厚仪
		JMCHY("角膜测厚仪"),
		// ebhnkjxt---耳鼻喉内窥镜系统
		EBHNKJXT("耳鼻喉内窥镜系统"),
		// tjyfdwy---听觉诱发电位仪
		TJYFDWY("听觉诱发电位仪"),
		// ebhzhzlt---耳鼻喉综合治疗台
		EBHZHZLT("耳鼻喉综合治疗台"),
		// szkzefxy---声阻抗中耳分析仪
		SZKZEFXY("声阻抗中耳分析仪"),
		// dcty---电测听仪
		DCTY("电测听仪"),
		// kshj---可视喉镜
		KSHJ("可视喉镜"), QTQZM("其它（请注明）");

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		// 构造方法
		private IRONFOYKEBHK(String name) {
			this.name = name;

		}

		public static IRONFOYKEBHK getEnumbyname(String name) {
			for (IRONFOYKEBHK jz : IRONFOYKEBHK.values()) {
				if (String.valueOf(name) == String.valueOf(jz.getName())
						|| String.valueOf(name).equals(String.valueOf(jz.getName()))) {
					return jz;
				}

			}
			return null;
		}
	}

	/**
	 ** 眼科、耳鼻咽喉科
	 * 
	 * @author MikeSun
	 *
	 */
	public enum IRONFOZYK {
		// mzy---脉诊仪
		MZY("脉诊仪"),
		// szy---舌诊仪
		SZY("舌诊仪"),
		// zykmzy---面诊仪
		ZYKMZY("面诊仪"),
		// jljcy---经络检测仪
		JLJCY("经络检测仪"),
		// jlcjy---经络刺激仪
		JLCJY("经络刺激仪"),
		// zykwzy---温针仪
		ZYKWZY("温针仪"),
		// zykzlj---灸疗机
		ZYKZLJ("灸疗机"),
		// zykgly---罐疗仪
		ZYKGLY("罐疗仪"),
		// xzzly---熏蒸治疗仪
		XZZLY("熏蒸治疗仪"),
		// wbzjzly----微波针灸治疗仪
		WBZJZLY("微波针灸治疗仪"),
		// jgxwzly---激光穴位治疗仪
		JGXWZLY("激光穴位治疗仪"),

		QTQZM("其它（请注明）");

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		// 构造方法
		private IRONFOZYK(String name) {
			this.name = name;

		}

		public static IRONFOZYK getEnumbyname(String name) {
			for (IRONFOZYK jz : IRONFOZYK.values()) {
				if (String.valueOf(name) == String.valueOf(jz.getName())
						|| String.valueOf(name).equals(String.valueOf(jz.getName()))) {
					return jz;
				}

			}
			return null;
		}
	}

	/**
	 ** 住院部管理
	 * 
	 * @author MikeSun
	 *
	 */
	public enum IRONFOZYBGL {
		// xdtj---心电图机
		XDTJ("心电图机"),
		// dtxyjcy---动态血压监测仪
		DTXYJCY("动态血压监测仪"),
		// dtxdtj---动态心电图机
		DTXDTJ("动态心电图机"),
		// dtxtjcxt---动态血糖监测系统
		DTXTJCXT("动态血糖监测系统"),
		// zyjhxt---中央监护系统
		ZYJHXT("中央监护系统"),
		// dcsjhy---多参数监护仪
		DCSJHY("多参数监护仪"),
		// bfch---病房传呼
		BFCH("病房传呼"),
		// ccy---除颤仪
		CCY("除颤仪"),
		// dgnbc---多功能病床
		DGNBC("多功能病床"), 
		QTQZM("其它（请注明）"),
		ISNULL("是否配置");

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		// 构造方法
		private IRONFOZYBGL(String name) {
			this.name = name;

		}

		public static IRONFOZYBGL getEnumbyname(String name) {
			for (IRONFOZYBGL jz : IRONFOZYBGL.values()) {
				if (String.valueOf(name) == String.valueOf(jz.getName())
						|| String.valueOf(name).equals(String.valueOf(jz.getName()))) {
					return jz;
				}

			}
			return null;
		}
	}

	/**
	 ** 公共卫生部
	 * 
	 * @author MikeSun
	 *
	 */
	public enum IRONFOGGWSB {
		// sctzj---身长体重计
		SCTZJ("身长体重计"),
		// ettzc---儿童体重秤
		ETTZC("儿童体重秤"),
		// scxesfsy---筛查型耳声发射仪
		SCXESFSY("筛查型耳声发射仪"),
		// tljcy---听力监测仪
		TLJCY("听力监测仪"),
		// fgny---肺功能仪
		FGNY("肺功能仪"),
		// rtcffxy---人体成分分析仪
		RTCFFXY("人体成分分析仪"),
		// slb---视力表
		SLB("视力表"),
		// yylcldx---医用冷藏冷冻箱
		YYLCLDX("医用冷藏冷冻箱"),
		// lcb---冷藏包
		LCB("冷藏包"),
		// hxq---毁形器
		HXQ("毁形器"),
		// fkzlc---妇科诊疗床
		FKZLC("妇科诊疗床"), QTQZM("其它（请注明）");

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		// 构造方法
		private IRONFOGGWSB(String name) {
			this.name = name;

		}

		public static IRONFOGGWSB getEnumbyname(String name) {
			for (IRONFOGGWSB jz : IRONFOGGWSB.values()) {
				if (String.valueOf(name) == String.valueOf(jz.getName())
						|| String.valueOf(name).equals(String.valueOf(jz.getName()))) {
					return jz;
				}

			}
			return null;
		}
	}

	/**
	 ** 计划生育部
	 * 
	 * @author MikeSun
	 *
	 */
	public enum IRONFOJHSYB {
		// lcxyq ---流产吸引器
		LCXYQ("流产吸引器"),
		// ksrlssxt ---可视人流手术系统
		KSRLSSXT("可视人流手术系统"),
		// fkzlc ---妇科诊疗床
		FKZLC("妇科诊疗床"), QTQZM("其它（请注明）");

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		// 构造方法
		private IRONFOJHSYB(String name) {
			this.name = name;

		}

		public static IRONFOJHSYB getEnumbyname(String name) {
			for (IRONFOJHSYB jz : IRONFOJHSYB.values()) {
				if (String.valueOf(name) == String.valueOf(jz.getName())
						|| String.valueOf(name).equals(String.valueOf(jz.getName()))) {
					return jz;
				}

			}
			return null;
		}
	}
	
	/**
	 * 4.1信息化系统建设情况
	 */
	public enum IRONFOXXHJS {
		// yyxxxthis-----医院信息系统HIS
		YYXXXTHIS("乡镇卫生院信息管理系统"),
		//lcxxxtcis ----临床信息系统CIS
		LCXXXTCIS("基本公共卫生信息管理系统"),
		// dzblxtemr ---电子病历系统EMR电子病历系统EMR
		DZBLXTEMR("基本医疗信息管理系统"), 
		
		//yxyxcdytxxtpscs ---医学影像存档与通讯系统PACS电子健康档案系统EHR 
//		YXYXCDYTXXTPSCS("远程医疗信息系统"), 
//		// dzjkdaxtehr ---电子健康档案系统EHR
		DZJKDAXTEHR("远程医疗信息系统"), 
//	    // sysxxxtlis ---实验室信息系统LIS
//		SYSXXXTLIS("实验室信息系统LIS"), 
//		// ycylxttis ----远程医疗系统TIS
//		YCYLXTTIS("远程医疗系统TIS"), 
		QTQZM("其它（请注明）");

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		// 构造方法
		private IRONFOXXHJS(String name) {
			this.name = name;

		}

		public static IRONFOXXHJS getEnumbyname(String name) {
			for (IRONFOXXHJS jz : IRONFOXXHJS.values()) {
				if (String.valueOf(name) == String.valueOf(jz.getName())
						|| String.valueOf(name).equals(String.valueOf(jz.getName()))) {
					return jz;
				}

			}
			return null;
		}
	}
	
	/**
	 * 2.4科室设置
	 * 
	 */
   
	
	/*public enum KSSZ{
		
	}*/

}
