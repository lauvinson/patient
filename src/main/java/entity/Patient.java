package entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Patient {

    /**
     * NO
     */
    @ExcelProperty(index = 0)
    private String no;

    /**
     * 病例ID
     */
    @ExcelProperty(index = 1)
    private String caseId;

    /**
     * 姓名
     */
    @ExcelProperty(index = 2)
    private String name;

    /**
     * 身份证ID
     */
    @ExcelProperty(index = 3)
    private String idNo;

    /**
     * 样本源编号
     */
    @ExcelProperty(index = 4)
    private String sampleSrcNo;

    /**
     * 血液样本编号
     */
    @ExcelProperty(index = 5)
    private String bloodSampleNo;

    /**
     * 组织样本编号
     */
    @ExcelProperty(index = 6)
    private String tissueSampleNo;

    /**
     * 年龄（岁）
     */
    @ExcelProperty(index = 7)
    private String age;

    /**
     * 身高cm
     */
    @ExcelProperty(index = 8)
    private String height;

    /**
     * 体重kg
     */
    @ExcelProperty(index = 9)
    private String weight;

    /**
     * 民族
     */
    @ExcelProperty(index = 10)
    private String ethnicity;

    /**
     * 受教育程度
     */
    @ExcelProperty(index = 11)
    private String education;

    /**
     * 工作
     */
    @ExcelProperty(index = 12)
    private String occupation;

    /**
     * 婚姻状态
     */
    @ExcelProperty(index = 13)
    private String maritalStatus;

    /**
     * 孕次
     */
    @ExcelProperty(index = 14)
    private String pregnancyCount;

    /**
     * 产次
     */
    @ExcelProperty(index = 15)
    private String deliveryCount;

    /**
     * 剖宫产次
     */
    @ExcelProperty(index = 16)
    private String csectionCount;

    /**
     * 顺产次
     */
    @ExcelProperty(index = 17)
    private String vaginalDeliveryCount;

    /**
     * 中医证型
     */
    @ExcelProperty(index = 18)
    private String tcmSyndrome;

    /**
     * 盆底电生理检测
     */
    @ExcelProperty(index = 19)
    private String pfdElectrophysiologyTest;

    /**
     * 痔病
     */
    @ExcelProperty(index = 20)
    private String hemorrhoids;

    /**
     * 肛瘘
     */
    @ExcelProperty(index = 21)
    private String analFistula;

    /**
     * 便秘
     */
    @ExcelProperty(index = 22)
    private String constipation;

    /**
     * 排便困难
     */
    @ExcelProperty(index = 23)
    private String defecationDifficulty;

    /**
     * 直肠脱垂
     */
    @ExcelProperty(index = 24)
    private String rectalProlapse;

    /**
     * 肛门失禁
     */
    @ExcelProperty(index = 25)
    private String analIncontinence;

    /**
     * 尿失禁
     */
    @ExcelProperty(index = 26)
    private String urinaryIncontinence;

    /**
     * 阴道子宫脱垂
     */
    @ExcelProperty(index = 27)
    private String uterovaginalProlapse;

    /**
     * 糖尿病
     */
    @ExcelProperty(index = 28)
    private String diabetes;

    /**
     * 高血压
     */
    @ExcelProperty(index = 29)
    private String hypertension;

    /**
     * 心脏病
     */
    @ExcelProperty(index = 30)
    private String cardiacDisease;

    /**
     * 肝病
     */
    @ExcelProperty(index = 31)
    private String liverDisease;

    /**
     * 肾病
     */
    @ExcelProperty(index = 32)
    private String kidneyDisease;

    /**
     * 恶性肿瘤
     */
    @ExcelProperty(index = 33)
    private String malignantTumor;

    /**
     * 阴道炎
     */
    @ExcelProperty(index = 34)
    private String vaginitis;

    /**
     * 坐骨神经痛
     */
    @ExcelProperty(index = 35)
    private String sciatica;

    /**
     * 吸烟史
     */
    @ExcelProperty(index = 36)
    private String smokingHistory;

    /**
     * 慢性咳嗽
     */
    @ExcelProperty(index = 37)
    private String chronicCough;

    /**
     * 腰椎疾病
     */
    @ExcelProperty(index = 38)
    private String lumbarSpineDisease;

    /**
     * 便秘、排便困难
     */
    @ExcelProperty(index = 39)
    private String constipationDefecationDifficulty;

    /**
     * 无法排尽大便
     */
    @ExcelProperty(index = 40)
    private String unableToDefecateCompletely;

    /**
     * 在大便成形的情况下,经常不能控制排便
     */
    @ExcelProperty(index = 41)
    private String incontinenceOfFormedStool;

    /**
     * 当大便松散时,经常不能控制排便
     */
    @ExcelProperty(index = 42)
    private String incontinenceOfLooseStool;

    /**
     * 经常不能控制肛门排气
     */
    @ExcelProperty(index = 43)
    private String inabilityToControlFlatulence;

    /**
     * 经常在排便时感到疼痛
     */
    @ExcelProperty(index = 44)
    private String painOnDefecation;

    /**
     * 排便急迫,不得不奔向卫生间去排便
     */
    @ExcelProperty(index = 45)
    private String fecalUrgency;

    /**
     * 在排便时或之后感到有肠管从直肠脱出
     */
    @ExcelProperty(index = 46)
    private String sensationOfRectalProtrusion;

    /**
     * 排便频率
     */
    @ExcelProperty(index = 47)
    private String defecationFrequency;

    /**
     * 排便费力
     */
    @ExcelProperty(index = 48)
    private String strainedDefecation;

    /**
     * 排便不尽感
     */
    @ExcelProperty(index = 49)
    private String sensationOfIncompleteBowelEvacuation;

    /**
     * 腹痛
     */
    @ExcelProperty(index = 50)
    private String abdomenPain;

    /**
     * 每次如厕时间,分钟
     */
    @ExcelProperty(index = 51)
    private String defecationDuration;

    /**
     * 排便辅助方法
     */
    @ExcelProperty(index = 52)
    private String defecationAssistanceMethod;

    /**
     * 每天去排便但没有排出来的次数
     */
    @ExcelProperty(index = 53)
    private String unsuccessfulDefecationAttemptsPerDay;

    /**
     * 病程,年
     */
    @ExcelProperty(index = 54)
    private String diseaseCourseDuration;

    /**
     * 总体来讲,您的健康状况是
     */
    @ExcelProperty(index = 55)
    private String overallHealthStatus;

    /**
     * 中度活动。如移动一张桌子、扫地、打太极拳、做简单体操等
     */
    @ExcelProperty(index = 56)
    private String moderateActivity;

    /**
     * 上几层楼梯
     */
    @ExcelProperty(index = 57)
    private String climbingStairs;

    /**
     * 身体健康的原因--使您想做的事（包括日常生活和家务劳动）只能完成一部分
     */
    @ExcelProperty(index = 58)
    private String physicalLimitationsOnActivities;

    /**
     * 身体健康的原因--您日常活动的种类受到限制
     */
    @ExcelProperty(index = 59)
    private String physicalLimitationsOnActivityTypes;

    /**
     * 情绪的原因--使您想做的事（包括日常生活和家务劳动）只能完成一部分
     */
    @ExcelProperty(index = 60)
    private String emotionalLimitationsOnActivities;

    /**
     * 情绪的原因--您日常活动的种类受到限制
     */
    @ExcelProperty(index = 61)
    private String emotionalLimitationsOnActivityTypes;

    /**
     * 情绪的原因--您日常活动的种类受到限制
     */
    @ExcelProperty(index = 62)
    private String emotionalLimitationsOnActivityTypes2;

    /**
     * 过去4周里您自己感到心平气和
     */
    @ExcelProperty(index = 63)
    private String calmInLastFourWeeks;

    /**
     * 过去4周里您自己感到精力充沛
     */
    @ExcelProperty(index = 64)
    private String energeticInLastFourWeeks;

    /**
     * 过去4周里您自己感到感到心情不好,闷闷不乐
     */
    @ExcelProperty(index = 65)
    private String downInLastFourWeeks;

    /**
     * 在过去4周,有多少时间你的社会活动（如访问朋友、亲戚等）受健康或情感问题的影响
     */
    @ExcelProperty(index = 66)
    private String socialActivityLimitationInLastFourWeeks;

    /**
     * 固体
     */
    @ExcelProperty(index = 67)
    private String solid;

    /**
     * 液体
     */
    @ExcelProperty(index = 68)
    private String liquid;

    /**
     * 气体
     */
    @ExcelProperty(index = 69)
    private String gas;

    /**
     * 使用尿布
     */
    @ExcelProperty(index = 70)
    private String useDiaper;

    /**
     * 生活方式的改变
     */
    @ExcelProperty(index = 71)
    private String lifestyleChanges;

    // Getters and Setters
}