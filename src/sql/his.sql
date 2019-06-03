/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50559
Source Host           : localhost:3306
Source Database       : his

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2019-06-01 14:37:20
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `bill`
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `billid` int(10) NOT NULL AUTO_INCREMENT,
  `totalprice` double(20,0) NOT NULL,
  `pid` int(10) NOT NULL,
  `count` int(10) NOT NULL,
  `billdate` date NOT NULL,
  `isPaid` tinyint(1) NOT NULL,
  `itemcode` varchar(40) NOT NULL,
  `isPrint` tinyint(1) NOT NULL,
  `feecode` varchar(40) NOT NULL,
  `isDone` tinyint(1) NOT NULL,
  `billcat` varchar(40) NOT NULL,
  PRIMARY KEY (`billid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bill
-- ----------------------------

-- ----------------------------
-- Table structure for `constant`
-- ----------------------------
DROP TABLE IF EXISTS `constant`;
CREATE TABLE `constant` (
  `constid` int(10) NOT NULL,
  `constcode` varchar(40) NOT NULL,
  `consttype` varchar(40) NOT NULL,
  `constname` varchar(40) NOT NULL,
  PRIMARY KEY (`constid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of constant
-- ----------------------------
INSERT INTO `constant` VALUES ('1', 'ZF', 'billcat', '自费');
INSERT INTO `constant` VALUES ('2', 'YB', 'billcat', '医保');
INSERT INTO `constant` VALUES ('3', 'XNH', 'billcat', '新农合');

-- ----------------------------
-- Table structure for `dailyrecord`
-- ----------------------------
DROP TABLE IF EXISTS `dailyrecord`;
CREATE TABLE `dailyrecord` (
  `drid` int(10) NOT NULL AUTO_INCREMENT,
  `userid` int(10) NOT NULL,
  `state` varchar(40) NOT NULL,
  `recordtime` datetime NOT NULL,
  PRIMARY KEY (`drid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dailyrecord
-- ----------------------------

-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptcode` varchar(255) NOT NULL,
  `deptname` varchar(255) NOT NULL,
  `deptcat` varchar(255) NOT NULL,
  `deptclass` varchar(255) NOT NULL,
  PRIMARY KEY (`deptcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('BTFYK', '变态反应科', '内科', '临床科室');
INSERT INTO `dept` VALUES ('CK', '产科', '妇产科', '临床科室');
INSERT INTO `dept` VALUES ('CQJCK', '产前检查科', '妇产科', '临床科室');
INSERT INTO `dept` VALUES ('CRK', '传染科', '传染病科', '临床科室');
INSERT INTO `dept` VALUES ('CRWZS', '传染危重室', '传染病科', '临床科室');
INSERT INTO `dept` VALUES ('CSGK', '创伤骨科', '骨科', '临床科室');
INSERT INTO `dept` VALUES ('CSZDK', '超声诊断科', '医学影像学', '医技科室');
INSERT INTO `dept` VALUES ('CWK', '财务科', '其他科室', '财务科室');
INSERT INTO `dept` VALUES ('EBYHTJK', '耳鼻咽喉头颈科', '五官科', '临床科室');
INSERT INTO `dept` VALUES ('EKZH', '儿科综合', '儿科', '临床科室');
INSERT INTO `dept` VALUES ('ETBJK', '儿童保健科', '儿科', '临床科室');
INSERT INTO `dept` VALUES ('FCKZH', '妇产科综合', '妇产科', '临床科室');
INSERT INTO `dept` VALUES ('FK', '妇科', '妇产科', '临床科室');
INSERT INTO `dept` VALUES ('FKNFM', '妇科内分泌', '妇产科', '临床科室');
INSERT INTO `dept` VALUES ('FLK', '放疗科', '肿瘤科', '临床科室');
INSERT INTO `dept` VALUES ('FMNK', '妇泌尿科', '妇产科', '临床科室');
INSERT INTO `dept` VALUES ('FSK', '放射科', '医学影像学', '医技科室');
INSERT INTO `dept` VALUES ('FSMYNK', '风湿免疫内科', '内科', '临床科室');
INSERT INTO `dept` VALUES ('GBK', '肝病科', '传染病科', '临床科室');
INSERT INTO `dept` VALUES ('GCWK', '肛肠外科', '外科', '临床科室');
INSERT INTO `dept` VALUES ('GDWK', '肝胆外科', '外科', '临床科室');
INSERT INTO `dept` VALUES ('GGJK', '骨关节科', '骨科', '临床科室');
INSERT INTO `dept` VALUES ('GGWSYYFK', '公共卫生与预防科', '其他科室', '医技科室');
INSERT INTO `dept` VALUES ('GNJCK', '功能检查科', '医技科', '医技科室');
INSERT INTO `dept` VALUES ('GNSJWK', '功能神经外科', '外科', '临床科室');
INSERT INTO `dept` VALUES ('GRNK', '感染内科', '内科', '临床科室');
INSERT INTO `dept` VALUES ('GWK', '骨外科', '骨科', '临床科室');
INSERT INTO `dept` VALUES ('GYYK', '高压氧科', '医技科', '医技科室');
INSERT INTO `dept` VALUES ('GZLK', '骨肿瘤科', '肿瘤科', '临床科室');
INSERT INTO `dept` VALUES ('GZSSK', '骨质疏松科', '骨科', '临床科室');
INSERT INTO `dept` VALUES ('HLK', '护理科', '其他科室', '医技科室');
INSERT INTO `dept` VALUES ('HXNK', '呼吸内科', '内科', '临床科室');
INSERT INTO `dept` VALUES ('HY学K', '核医学科', '医学影像学', '医技科室');
INSERT INTO `dept` VALUES ('JHSYK', '计划生育科', '妇产科', '临床科室');
INSERT INTO `dept` VALUES ('JSK', '精神科', '精神心理科', '临床科室');
INSERT INTO `dept` VALUES ('JXGK', '矫形骨科', '骨科', '临床科室');
INSERT INTO `dept` VALUES ('JYK', '检验科', '医技科', '医技科室');
INSERT INTO `dept` VALUES ('JZK', '急诊科', '其他科室', '医技科室');
INSERT INTO `dept` VALUES ('JZWK', '脊柱外科', '骨科', '临床科室');
INSERT INTO `dept` VALUES ('KFK', '康复科', '康复医学科', '医技科室');
INSERT INTO `dept` VALUES ('KQK', '口腔科', '五官科', '临床科室');
INSERT INTO `dept` VALUES ('LLK', '理疗科', '康复医学科', '医技科室');
INSERT INTO `dept` VALUES ('LNBNK', '老年病内科', '内科', '临床科室');
INSERT INTO `dept` VALUES ('MNWK', '泌尿外科', '外科', '临床科室');
INSERT INTO `dept` VALUES ('MZK', '麻醉科', '麻醉医学科', '医技科室');
INSERT INTO `dept` VALUES ('NFMK', '内分泌科', '内科', '临床科室');
INSERT INTO `dept` VALUES ('NXBY', '男性不育', '男科', '临床科室');
INSERT INTO `dept` VALUES ('PFK', '皮肤科', '皮肤性病科', '临床科室');
INSERT INTO `dept` VALUES ('PTNK', '普通内科', '内科', '临床科室');
INSERT INTO `dept` VALUES ('PTWK', '普通外科', '外科', '临床科室');
INSERT INTO `dept` VALUES ('QGYZ', '器官移植', '外科', '临床科室');
INSERT INTO `dept` VALUES ('QLX', '前列腺', '男科', '临床科室');
INSERT INTO `dept` VALUES ('RXWK', '乳腺外科', '外科', '临床科室');
INSERT INTO `dept` VALUES ('SBK', '设备科', '其他科室', '行政科室');
INSERT INTO `dept` VALUES ('SBNK', '肾病内科', '内科', '临床科室');
INSERT INTO `dept` VALUES ('SFJDK', '司法鉴定科', '精神心理科', '临床科室');
INSERT INTO `dept` VALUES ('SJNK', '神经内科', '内科', '临床科室');
INSERT INTO `dept` VALUES ('SJWK', '神经外科', '外科', '临床科室');
INSERT INTO `dept` VALUES ('SWK', '手外科', '骨科', '临床科室');
INSERT INTO `dept` VALUES ('SXZAK', '双相障碍科', '精神心理科', '临床科室');
INSERT INTO `dept` VALUES ('SYZX', '实验中心', '医技科', '医技科室');
INSERT INTO `dept` VALUES ('SZQGR', '生殖器感染', '男科', '临床科室');
INSERT INTO `dept` VALUES ('SZZX', '生殖整形', '男科', '临床科室');
INSERT INTO `dept` VALUES ('TJK', '体检科', '其他科室', '医技科室');
INSERT INTO `dept` VALUES ('TTK', '疼痛科', '麻醉医学科', '医技科室');
INSERT INTO `dept` VALUES ('TXK', '透析科', '内科', '临床科室');
INSERT INTO `dept` VALUES ('WCWK', '微创外科', '外科', '临床科室');
INSERT INTO `dept` VALUES ('XBK', '性病科', '皮肤性病科', '临床科室');
INSERT INTO `dept` VALUES ('XDTK', '心电图科', '医技科', '医技科室');
INSERT INTO `dept` VALUES ('XEEBHK', '小儿耳鼻喉科', '儿科', '临床科室');
INSERT INTO `dept` VALUES ('XEFK', '小儿妇科', '儿科', '临床科室');
INSERT INTO `dept` VALUES ('XEFSMYK', '小儿风湿免疫科', '儿科', '临床科室');
INSERT INTO `dept` VALUES ('XEGK', '小儿骨科', '儿科', '临床科室');
INSERT INTO `dept` VALUES ('XEGRK', '小儿感染科', '儿科', '临床科室');
INSERT INTO `dept` VALUES ('XEHXK', '小儿呼吸科', '儿科', '临床科室');
INSERT INTO `dept` VALUES ('XEJSK', '小儿精神科', '儿科', '临床科室');
INSERT INTO `dept` VALUES ('XEJZK', '小儿急诊科', '儿科', '临床科室');
INSERT INTO `dept` VALUES ('XEKFK', '小儿康复科', '儿科', '临床科室');
INSERT INTO `dept` VALUES ('XEMNWK', '小儿泌尿外科', '儿科', '临床科室');
INSERT INTO `dept` VALUES ('XENFMK', '小儿内分泌科', '儿科', '临床科室');
INSERT INTO `dept` VALUES ('XEPFK', '小儿皮肤科', '儿科', '临床科室');
INSERT INTO `dept` VALUES ('XESJNK', '小儿神经内科', '儿科', '临床科室');
INSERT INTO `dept` VALUES ('XESJWK', '小儿神经外科', '儿科', '临床科室');
INSERT INTO `dept` VALUES ('XESNK', '小儿肾内科', '儿科', '临床科室');
INSERT INTO `dept` VALUES ('XEWK', '小儿外科', '儿科', '临床科室');
INSERT INTO `dept` VALUES ('XEXHK', '小儿消化科', '儿科', '临床科室');
INSERT INTO `dept` VALUES ('XEXNK', '小儿心内科', '儿科', '临床科室');
INSERT INTO `dept` VALUES ('XEXWK01', '小儿心外科', '儿科', '临床科室');
INSERT INTO `dept` VALUES ('XEXWK02', '小儿胸外科', '儿科', '临床科室');
INSERT INTO `dept` VALUES ('XEXYK', '小儿血液科', '儿科', '临床科室');
INSERT INTO `dept` VALUES ('XEZXK', '小儿整形科', '儿科', '临床科室');
INSERT INTO `dept` VALUES ('XGNZA', '性功能障碍', '男科', '临床科室');
INSERT INTO `dept` VALUES ('XHNK', '消化内科', '内科', '临床科室');
INSERT INTO `dept` VALUES ('XSEK', '新生儿科', '儿科', '临床科室');
INSERT INTO `dept` VALUES ('XTWK', '腺体外科', '外科', '临床科室');
INSERT INTO `dept` VALUES ('XWK', '胸外科', '外科', '临床科室');
INSERT INTO `dept` VALUES ('XXGNK', '心血管内科', '内科', '临床科室');
INSERT INTO `dept` VALUES ('XXGWK', '心血管外科', '外科', '临床科室');
INSERT INTO `dept` VALUES ('XYNK', '血液内科', '内科', '临床科室');
INSERT INTO `dept` VALUES ('XZWK', '心脏外科', '外科', '临床科室');
INSERT INTO `dept` VALUES ('YCZYK', '遗传咨询科', '妇产科', '临床科室');
INSERT INTO `dept` VALUES ('YJK', '药剂科', '其他科室', '医技科室');
INSERT INTO `dept` VALUES ('YK', '眼科', '五官科', '临床科室');
INSERT INTO `dept` VALUES ('YWYLK', '药物依赖科', '精神心理科', '临床科室');
INSERT INTO `dept` VALUES ('YXYXK', '医学影像科', '医学影像学', '医技科室');
INSERT INTO `dept` VALUES ('YYGLK', '医院管理科', '其他科室', '行政科室');
INSERT INTO `dept` VALUES ('YYK', '营养科', '营养科', '医技科室');
INSERT INTO `dept` VALUES ('ZJK', '针灸科', '中医科', '临床科室');
INSERT INTO `dept` VALUES ('ZLFK', '肿瘤妇科', '肿瘤科', '临床科室');
INSERT INTO `dept` VALUES ('ZLKFK', '肿瘤康复科', '肿瘤科', '临床科室');
INSERT INTO `dept` VALUES ('ZLNK', '肿瘤内科', '肿瘤科', '临床科室');
INSERT INTO `dept` VALUES ('ZLWK', '肿瘤外科', '肿瘤科', '临床科室');
INSERT INTO `dept` VALUES ('ZLZHK', '肿瘤综合科', '肿瘤科', '临床科室');
INSERT INTO `dept` VALUES ('ZXWK', '整形外科', '外科', '临床科室');
INSERT INTO `dept` VALUES ('ZYAMK', '中医按摩科', '中医科', '临床科室');
INSERT INTO `dept` VALUES ('ZYEK', '中医儿科', '中医科', '临床科室');
INSERT INTO `dept` VALUES ('ZYFCK', '中医妇产科', '中医科', '临床科室');
INSERT INTO `dept` VALUES ('ZYFSMYNK', '中医风湿免疫内科', '中医科', '临床科室');
INSERT INTO `dept` VALUES ('ZYGBK', '中医肝病科', '中医科', '临床科室');
INSERT INTO `dept` VALUES ('ZYGCK', '中医肛肠科', '中医科', '临床科室');
INSERT INTO `dept` VALUES ('ZYGK', '中医骨科', '中医科', '临床科室');
INSERT INTO `dept` VALUES ('ZYHXK', '中医呼吸科', '中医科', '临床科室');
INSERT INTO `dept` VALUES ('ZYJSK', '中医精神科', '精神心理科', '临床科室');
INSERT INTO `dept` VALUES ('ZYLNBK', '中医老年病科', '中医科', '临床科室');
INSERT INTO `dept` VALUES ('ZYNFM', '中医内分泌', '中医科', '临床科室');
INSERT INTO `dept` VALUES ('ZYNK', '中医男科', '中医科', '临床科室');
INSERT INTO `dept` VALUES ('ZYPFK', '中医皮肤科', '中医科', '临床科室');
INSERT INTO `dept` VALUES ('ZYRXWK', '中医乳腺外科', '中医科', '临床科室');
INSERT INTO `dept` VALUES ('ZYSBNK', '中医肾病内科', '中医科', '临床科室');
INSERT INTO `dept` VALUES ('ZYSJNK', '中医神经内科', '中医科', '临床科室');
INSERT INTO `dept` VALUES ('ZYWGK', '中医五官科', '中医科', '临床科室');
INSERT INTO `dept` VALUES ('ZYWK', '中医外科', '中医科', '临床科室');
INSERT INTO `dept` VALUES ('ZYXHK', '中医消化科', '中医科', '临床科室');
INSERT INTO `dept` VALUES ('ZYXNK', '中医心内科', '中医科', '临床科室');
INSERT INTO `dept` VALUES ('ZYXYK', '中医血液科', '中医科', '临床科室');
INSERT INTO `dept` VALUES ('ZYZHK', '中医综合科', '中医科', '临床科室');
INSERT INTO `dept` VALUES ('ZYZLK', '中医肿瘤科', '中医科', '临床科室');

-- ----------------------------
-- Table structure for `disease`
-- ----------------------------
DROP TABLE IF EXISTS `disease`;
CREATE TABLE `disease` (
  `icdcode` varchar(40) NOT NULL,
  `discode` varchar(40) NOT NULL,
  `discat` varchar(40) NOT NULL,
  `disname` varchar(40) NOT NULL,
  PRIMARY KEY (`icdcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of disease
-- ----------------------------
INSERT INTO `disease` VALUES ('A00.051', 'GDXHL', '霍乱', '古典型霍乱');
INSERT INTO `disease` VALUES ('A00.052', 'ZXDXHL', '霍乱', '中型[典型]霍乱');
INSERT INTO `disease` VALUES ('A00.053', 'ZXBFXHGXHL', '霍乱', '重型[暴发型或干性]霍乱');
INSERT INTO `disease` VALUES ('A00.151', 'QXFDXHL', '霍乱', '轻型[非典型]霍乱');
INSERT INTO `disease` VALUES ('A00.152', 'AETHL', '霍乱', '埃尔托霍乱');
INSERT INTO `disease` VALUES ('A00.153', 'AETXCY', '肠炎', '埃尔托小肠炎');
INSERT INTO `disease` VALUES ('A00.901', 'HL', '霍乱', '霍乱 NOS');
INSERT INTO `disease` VALUES ('A01.001', 'SH', '伤寒', '伤寒');
INSERT INTO `disease` VALUES ('A01.002', 'SHGJXBXZ', '伤寒', '伤寒杆菌性败血症');
INSERT INTO `disease` VALUES ('A01.003+', 'SHXNMY', '脑膜炎', '伤寒性脑膜炎');
INSERT INTO `disease` VALUES ('A01.051+', 'SHFY', '肺炎', '伤寒肺炎');
INSERT INTO `disease` VALUES ('A01.052', 'SHFMY', '伤寒', '伤寒腹膜炎');
INSERT INTO `disease` VALUES ('A01.053', 'ABTSBSH', '伤寒', '埃贝特Eberth`s氏病(伤寒)');
INSERT INTO `disease` VALUES ('A01.054', 'CCXXSH', '伤寒', '肠出血性伤寒');
INSERT INTO `disease` VALUES ('A01.055', 'SHXCCK', '伤寒', '伤寒性肠穿孔');
INSERT INTO `disease` VALUES ('A01.056', 'CSH', '伤寒', '肠伤寒');
INSERT INTO `disease` VALUES ('A01.057', 'SHYXCY', '肠炎', '伤寒样小肠炎');
INSERT INTO `disease` VALUES ('A01.101', 'JXFSH', '伤寒', '甲型副伤寒');
INSERT INTO `disease` VALUES ('A01.201', 'YXFSH', '伤寒', '乙型副伤寒');
INSERT INTO `disease` VALUES ('A01.301', 'BXFSH', '伤寒', '丙型副伤寒');
INSERT INTO `disease` VALUES ('A01.401', 'FSH', '伤寒', '副伤寒');
INSERT INTO `disease` VALUES ('A02.001', 'QSMSJCY', '肠炎', 'Ｂ群沙门氏菌肠炎');
INSERT INTO `disease` VALUES ('A02.002', 'QSMSJCY', '肠炎', 'Ｃ群沙门氏菌肠炎');
INSERT INTO `disease` VALUES ('A02.003', 'AGLSMSJCY', '肠炎', '阿哥拉沙门氏菌肠炎');
INSERT INTO `disease` VALUES ('A02.004', 'SMSJXCY', '肠炎', '沙门氏菌性肠炎');
INSERT INTO `disease` VALUES ('A02.005', 'SMSJLDXQXCY', '肠炎', '沙门氏菌伦敦血清型肠炎');
INSERT INTO `disease` VALUES ('A02.006', 'SMSJWCY', '肠炎', '沙门氏菌胃肠炎');
INSERT INTO `disease` VALUES ('A02.007', 'SSHSMSJXCY', '肠炎', '鼠伤寒沙门氏菌性肠炎');
INSERT INTO `disease` VALUES ('A02.008', 'YESMSJCY', '肠炎', '婴儿沙门氏菌肠炎');
INSERT INTO `disease` VALUES ('A02.051', 'SMSJCDGR', '肠道疾病', '沙门氏菌肠道感染');
INSERT INTO `disease` VALUES ('A02.052', 'SMSJYLSNXCY', '肠炎', '沙门氏菌(亚利桑那)小肠炎');
INSERT INTO `disease` VALUES ('A02.101', 'SMSJBXZ', '败血症', '沙门氏菌败血症');
INSERT INTO `disease` VALUES ('A02.102', 'SMSJSSHBYBXZ', '伤寒', '沙门氏菌鼠伤寒伴有败血症');
INSERT INTO `disease` VALUES ('A02.201+', 'SMSJXFY', '肺炎', '沙门氏菌性肺炎');
INSERT INTO `disease` VALUES ('A02.202+', 'SMSJXGJY', '关节疾病', '沙门氏菌性关节炎');
INSERT INTO `disease` VALUES ('A02.203+', 'SMSJXNMY', '脑膜炎', '沙门氏菌性脑膜炎');
INSERT INTO `disease` VALUES ('A02.251+', 'SMSJXGSY', '骨髓炎', '沙门氏菌性骨髓炎');
INSERT INTO `disease` VALUES ('A02.252+', 'SMSJXSXGJZB', '间质病', '沙门氏菌性肾小管-间质病');
INSERT INTO `disease` VALUES ('A02.851', 'QTTZDSMSJGR', '感染', '其他特指的沙门氏菌感染');
INSERT INTO `disease` VALUES ('A02.901', 'SMSJGR', '感染', '沙门氏菌感染 NOS');
INSERT INTO `disease` VALUES ('A02.902', 'SSHSMSJGR', '伤寒', '鼠伤寒沙门氏菌感染');
INSERT INTO `disease` VALUES ('A02.903', 'SMSJSSWZD', '食物中毒', '沙门氏菌属食物中毒');
INSERT INTO `disease` VALUES ('A03.001', 'SMSZHJLJ', '痢疾', '什密氏志贺菌痢疾');
INSERT INTO `disease` VALUES ('A03.051', 'ZHKLZLJYQZHJB', '痢疾', '志贺-克鲁泽痢疾[A亚群志贺菌病]');
INSERT INTO `disease` VALUES ('A03.052', 'SMCSDCLJ', '痢疾', '施米茨(－施蒂策)痢疾');
INSERT INTO `disease` VALUES ('A03.101', 'FSZHJLJ', '痢疾', '弗氏志贺菌痢疾');
INSERT INTO `disease` VALUES ('A03.151', 'XSLSXJXLJ', '细菌性疾病', '希斯－罗素细菌性痢疾');
INSERT INTO `disease` VALUES ('A03.201', 'BSZHJLJ', '痢疾', '鲍氏志贺菌痢疾');
INSERT INTO `disease` VALUES ('A03.251', 'BYDXJXLJ', '细菌性疾病', '波伊德细菌性痢疾');
INSERT INTO `disease` VALUES ('A03.301', 'SNSZHJLJ', '痢疾', '宋内氏志贺菌痢疾');
INSERT INTO `disease` VALUES ('A03.801', 'BDXZHJLJ', '痢疾', '不定型志贺菌痢疾');
INSERT INTO `disease` VALUES ('A03.802', 'JLHHGR', '感染', '菌痢混合感染');
INSERT INTO `disease` VALUES ('A03.851', 'QTZHJLJ', '痢疾', '其他志贺菌痢疾');
INSERT INTO `disease` VALUES ('A03.901', 'XJXLJ', '细菌性疾病', '细菌性痢疾 NOS');
INSERT INTO `disease` VALUES ('A03.902', 'MXXJXLJJXFZ', '细菌性疾病', '慢性细菌性痢疾急性发作');
INSERT INTO `disease` VALUES ('A03.903', 'MXQYXXJXLJ', '细菌性疾病', '慢性迁延型细菌性痢疾');
INSERT INTO `disease` VALUES ('A03.904', 'MXYFXJL', '其它暂时无法归类的', '慢性隐伏型菌痢');
INSERT INTO `disease` VALUES ('A03.905', 'ZDXBFXLJ', '痢疾', '中毒性[暴发型]痢疾');
INSERT INTO `disease` VALUES ('A03.951', 'XJXJCY', '肠炎', '细菌性结肠炎');
INSERT INTO `disease` VALUES ('A03.952+', 'XJXGJYLJ', '关节疾病', '细菌性关节炎痢疾');
INSERT INTO `disease` VALUES ('A04.001', 'XSECBYXDCAXSJCY', '肠炎', '新生儿肠病原性大肠埃希氏菌肠炎');
INSERT INTO `disease` VALUES ('A04.002', 'CBYXDCAXSJCY', '肠炎', '肠病原性大肠埃希氏菌肠炎');
INSERT INTO `disease` VALUES ('A04.051', 'CDYBXDCAXSJGR', '肠道疾病', '肠道原病性大肠埃希氏菌感染');
INSERT INTO `disease` VALUES ('A04.101', 'CDXDCAXSJCY', '肠炎', '肠毒性大肠埃希氏菌肠炎');
INSERT INTO `disease` VALUES ('A04.102', 'XSECDXDCAXSJCY', '肠炎', '新生儿肠毒性大肠埃希氏菌肠炎');
INSERT INTO `disease` VALUES ('A04.151', 'CDXDCAXSJGR', '感染', '肠毒性大肠埃希氏菌感染');
INSERT INTO `disease` VALUES ('A04.201', 'QXXDCAXSJCY', '肠炎', '侵袭性大肠埃希氏菌肠炎');



-- ----------------------------
-- Table structure for `exam`
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam` (
  `exid` int(10) NOT NULL AUTO_INCREMENT,
  `pid` int(10) NOT NULL,
  `uRid` int(10) NOT NULL,
  `tempid` int(10) DEFAULT NULL,
  `extype` varchar(40) NOT NULL,
  `state` varchar(40) NOT NULL,
  PRIMARY KEY (`exid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam
-- ----------------------------

-- ----------------------------
-- Table structure for `exrel`
-- ----------------------------
DROP TABLE IF EXISTS `exrel`;
CREATE TABLE `exrel` (
  `exRelid` int(10) NOT NULL AUTO_INCREMENT,
  `exid` int(10) NOT NULL,
  `itemcode` varchar(40) NOT NULL,
  PRIMARY KEY (`exRelid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exrel
-- ----------------------------

-- ----------------------------
-- Table structure for `fee`
-- ----------------------------
DROP TABLE IF EXISTS `fee`;
CREATE TABLE `fee` (
  `feecode` varchar(40) NOT NULL,
  `feename` varchar(40) NOT NULL,
  PRIMARY KEY (`feecode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fee
-- ----------------------------
INSERT INTO `fee` VALUES ('CSCLF', '超声材料费');
INSERT INTO `fee` VALUES ('CSJCF', '超声检查费');
INSERT INTO `fee` VALUES ('CTCLF', 'CT材料费');
INSERT INTO `fee` VALUES ('CTJCF', 'CT检查费');
INSERT INTO `fee` VALUES ('CZCLF', '处置材料费');
INSERT INTO `fee` VALUES ('CZF', '处置费');
INSERT INTO `fee` VALUES ('FSCLF', '放射材料费');
INSERT INTO `fee` VALUES ('FSJCF', '放射检查费');
INSERT INTO `fee` VALUES ('GHF', '挂号费');
INSERT INTO `fee` VALUES ('JYCLF', '检验材料费');
INSERT INTO `fee` VALUES ('JYF', '检验费');
INSERT INTO `fee` VALUES ('MRICLF', 'MRI材料费');
INSERT INTO `fee` VALUES ('MRIJCF', 'MRI检查费');
INSERT INTO `fee` VALUES ('MZF', '麻醉费');
INSERT INTO `fee` VALUES ('MZSSF', '门诊手术费');
INSERT INTO `fee` VALUES ('MZYF', '麻醉药费');
INSERT INTO `fee` VALUES ('QT', '其他');
INSERT INTO `fee` VALUES ('XYF', '西药费');
INSERT INTO `fee` VALUES ('ZCHYF', '中成药费');
INSERT INTO `fee` VALUES ('ZCYF', '中草药费');
INSERT INTO `fee` VALUES ('ZLF', '诊疗费');

-- ----------------------------
-- Table structure for `homepageframe`
-- ----------------------------
DROP TABLE IF EXISTS `homepage`;
CREATE TABLE `homepage` (
  `hpid` int(10) NOT NULL AUTO_INCREMENT,
  `discodeWest` varchar(255) NOT NULL,
  `regid` int(11) NOT NULL,
  `examAdvice` varchar(255) NOT NULL,
  `cheifCP` varchar(255) NOT NULL,
  `caution` varchar(255) NOT NULL,
  `phyExam` varchar(255) NOT NULL,
  `curHis` varchar(255) NOT NULL,
  `discodeEast` varchar(255) NOT NULL,
  `allergicHis` varchar(255) NOT NULL,
  `pastHis` varchar(255) NOT NULL,
  PRIMARY KEY (`hpid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of homepageframe
-- ----------------------------

-- ----------------------------
-- Table structure for `medicine`
-- ----------------------------
DROP TABLE IF EXISTS `medicine`;
CREATE TABLE `medicine` (
  `itemcode` varchar(40) NOT NULL,
  `medname` varchar(40) NOT NULL,
  `producer` varchar(40) NOT NULL,
  `feecode` varchar(40) NOT NULL,
  `unit` varchar(40) NOT NULL,
  `type` varchar(40) NOT NULL,
  `price` double(20,0) NOT NULL,
  `size` varchar(40) NOT NULL,
  PRIMARY KEY (`itemcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of medicine
-- ----------------------------
INSERT INTO `medicine` VALUES ('0.9%LHNZSY(BT)', '0.9%氯化钠注射液(百特)', '针剂', 'XYF', '袋', '针剂', '69', '1000ml×1袋');
INSERT INTO `medicine` VALUES ('0.9%LHNZSY(SP)', '0.9%氯化钠注射液(塑瓶)', '针剂', 'XYF', '瓶', '针剂', '14', '2.25g:250ml×1瓶');
INSERT INTO `medicine` VALUES ('0.9%LHNZSY(YBRD)', '0.9%氯化钠注射液(亚邦软袋)', '针剂', 'XYF', '袋', '针剂', '66', '500ml*1袋');
INSERT INTO `medicine` VALUES ('0.9%LHNZSY（BT）', '0.9%氯化钠注射液（百特）', '针剂', 'XYF', '瓶', '针剂', '47', '500ml×1袋');
INSERT INTO `medicine` VALUES ('0.9%LHNZSY（SP）', '0.9%氯化钠注射液（塑瓶）', '针剂', 'XYF', '支', '针剂', '9', '10ml:0.09×1支');
INSERT INTO `medicine` VALUES ('0.9%LHNZSY（YBRD）', '0.9%氯化钠注射液（亚邦软袋）', '针剂', 'XYF', '袋', '针剂', '13', '0.9%250ml×1袋');
INSERT INTO `medicine` VALUES ('10%PTTZSY(YBRD)', '10%葡萄糖注射液(亚邦软袋)', '针剂', 'XYF', '袋', '针剂', '5', '10g:100ml×1袋');
INSERT INTO `medicine` VALUES ('10%PTTZSY（BT）', '10%葡萄糖注射液（百特）', '针剂', 'XYF', '袋', '针剂', '24', '100ml×1袋');
INSERT INTO `medicine` VALUES ('5%PTTZSY（BT）', '5%葡萄糖注射液（百特）', '针剂', 'XYF', '袋', '针剂', '13', '50ml×1袋');
INSERT INTO `medicine` VALUES ('5%PTTZSY（YBRD）', '5%葡萄糖注射液（亚邦软袋）', '针剂', 'XYF', '袋', '针剂', '5', '5%250ml×1袋');
INSERT INTO `medicine` VALUES ('ACJP', '氨茶碱片', '片剂', 'XYF', '瓶', '片剂', '61', '0.1g×100片/瓶');
INSERT INTO `medicine` VALUES ('ADPP(ZPL)', '奥氮平片(再普乐)', '片剂', 'XYF', '盒', '片剂', '57', '5mg×28片/盒');
INSERT INTO `medicine` VALUES ('AESPXDP', '爱尔施牌消毒片', '片剂', 'XYF', '瓶', '片剂', '23', '100片×1瓶');
INSERT INTO `medicine` VALUES ('AFGHCRJN（AFDS）', '阿法骨化醇软胶囊（阿法迪三）', '胶囊', 'XYF', '盒', '胶囊', '1', '0.25ug×20粒/盒');
INSERT INTO `medicine` VALUES ('AFQKTP(TLN)', '氨酚羟考酮片(泰勒宁)', '片剂', 'XYF', '盒', '片剂', '14', '325mg/5mg×10片/盒');
INSERT INTO `medicine` VALUES ('AJQBZSY(DB)', '阿加曲班注射液(达贝)', '针剂', 'XYF', '支', '针剂', '7', '20ml：10mg×1支');
INSERT INTO `medicine` VALUES ('AKBTP(BTP)', '阿卡波糖片(拜糖平)', '片剂', 'XYF', '盒', '片剂', '56', '50mg×30片/盒');
INSERT INTO `medicine` VALUES ('ALXTZSY(BQX)', '奥拉西坦注射液(倍清星)', '针剂', 'XYF', '支', '针剂', '39', '5ml:1g×1支');
INSERT INTO `medicine` VALUES ('AMLZCRJN(AK)', '奥美拉唑肠溶胶囊(奥克)', '胶囊', 'XYF', '盒', '胶囊', '72', '20mg×14粒/盒');
INSERT INTO `medicine` VALUES ('ANJZSY', '安乃近注射液', '针剂', 'XYF', '盒', '针剂', '80', '2ml:0.5g×10支/盒');
INSERT INTO `medicine` VALUES ('ANQZP(RND)', '阿那曲唑片(瑞宁得)', '片剂', 'XYF', '盒', '片剂', '11', '1mg×14片/盒');
INSERT INTO `medicine` VALUES ('APLTP', '爱普列特片', '片剂', 'XYF', '盒', '片剂', '4', '5mg×10片/盒');
INSERT INTO `medicine` VALUES ('ASLB(AKBK)ZSY', '奥沙利铂(艾克博康)注射液', '针剂', 'XYF', '支', '针剂', '47', '40mg×1支');
INSERT INTO `medicine` VALUES ('ATFTTGP(LPT)', '阿托伐他汀钙片(立普妥)', '片剂', 'XYF', '盒', '片剂', '47', '20mg×7片/盒');
INSERT INTO `medicine` VALUES ('ATKYSSXSZSY(BL)', '阿替卡因肾上腺素注射液(必兰)', '针剂', 'XYF', '支', '针剂', '25', '1.7ml(68mg:17ug)×1支');
INSERT INTO `medicine` VALUES ('AWAJN（FX）', '阿维A胶囊（方希）', '胶囊', 'XYF', '盒', '胶囊', '2', '10mg×30粒/盒');
INSERT INTO `medicine` VALUES ('AXLWRG(WHNG)', '阿昔洛韦乳膏(无环鸟甘)', '软膏剂', 'XYF', '支', '软膏剂', '59', '10g:300mg×1支');
INSERT INTO `medicine` VALUES ('AXZLHN(ALT)ZSY', '奥硝唑氯化钠(奥立妥)注射液', '针剂', 'XYF', '袋', '针剂', '3', '100ml:0.5g×1袋');
INSERT INTO `medicine` VALUES ('AZDPP(BZ)', '阿折地平片(贝琪)', '片剂', 'XYF', '盒', '片剂', '8', '8mg×7片/盒');
INSERT INTO `medicine` VALUES ('AZSQLHNZSY(TQRA)', '阿扎司琼氯化钠注射液(天晴日安)', '针剂', 'XYF', '支', '针剂', '42', '100ml:10mg×1支');
INSERT INTO `medicine` VALUES ('AZTLKFY（YTJ）', '氨溴特罗口服液（易坦静）', '口服液类', 'XYF', '瓶', '口服液类', '66', '100ml×1瓶');
INSERT INTO `medicine` VALUES ('B  F', '苯  酚', '原料药', 'XYF', '瓶', '原料药', '36', '500g×1瓶');
INSERT INTO `medicine` VALUES ('BAGAAZSY(LZ）', '丙氨酰谷氨酰胺注射液(力肽）', '针剂', 'XYF', '瓶', '针剂', '1', '20g×100ml/瓶');
INSERT INTO `medicine` VALUES ('BBBTZSY(LMN)', '苯巴比妥注射液(鲁米那)', '针剂', 'XYF', '盒', '针剂', '5', '1ml:100mg×10支/盒');
INSERT INTO `medicine` VALUES ('BBTN', '巴比妥钠', '原料药', 'XYF', '瓶', '原料药', '50', '25g×1瓶');
INSERT INTO `medicine` VALUES ('BFSL', '白凡士林', '原料药', 'XYF', '瓶', '原料药', '1', '500g×1瓶');
INSERT INTO `medicine` VALUES ('BGBFKS', 'BG保妇康栓', '栓剂', 'XYF', '板', '栓剂', '29', '1.74g×8粒/板');
INSERT INTO `medicine` VALUES ('BGEBSTQLZZP(YLP)', 'BG厄贝沙坦氢氯噻嗪片(依伦平)', '片剂', 'XYF', '盒', '片剂', '86', '150mg/12.5mg×7片/盒');
INSERT INTO `medicine` VALUES ('BGGCXKL', 'BG甘草锌颗粒', '颗粒剂', 'ZCHYF', '盒', '颗粒剂', '22', '5g×10包/盒');
INSERT INTO `medicine` VALUES ('BGJSSZZTP(SNS)', 'BG酒石酸唑吡坦片(思诺思)', '片剂', 'XYF', '盒', '片剂', '3', '10mg×20片/盒');
INSERT INTO `medicine` VALUES ('BGRSFTTG(TT）P', 'BG瑞舒伐他汀钙(托妥）片', '片剂', 'XYF', '盒', '片剂', '3', '10mg×7片/盒');
INSERT INTO `medicine` VALUES ('BGYSDELZP(HXS)', 'BG盐酸地尔硫卓片(合心爽)', '片剂', 'XYF', '盒', '片剂', '5', '30.000mg*50片/盒');
INSERT INTO `medicine` VALUES ('BGYSEJSZHSP(TB)', 'BG盐酸二甲双胍缓释片(泰白)', '片剂', 'XYF', '盒', '片剂', '71', '0.5g×30片/盒');
INSERT INTO `medicine` VALUES ('BGYZMBP(YSC)', 'BG依折麦布片(益适纯)', '片剂', 'XYF', '盒', '片剂', '74', '10mg×5片/盒');
INSERT INTO `medicine` VALUES ('BGZ', '补骨脂', '中药饮片', 'ZCYF', 'Kg', '中药饮片', '51', '1000克/公斤');
INSERT INTO `medicine` VALUES ('BGZSLJN', 'BG茴三硫胶囊', '胶囊', 'ZCHYF', '盒', '胶囊', '12', '25mg×24粒/盒');
INSERT INTO `medicine` VALUES ('BGZSYGLJTZ(LEF）', 'BG注射用甘露聚糖肽(力尔凡）', '针剂', 'XYF', '支', '针剂', '25', '5mg×1支');
INSERT INTO `medicine` VALUES ('BGZSYHLXZPA(KZ)', 'BG注射用环磷腺苷葡胺(凯缌)', '针剂', 'XYF', '支', '针剂', '20', '60mg×1支');
INSERT INTO `medicine` VALUES ('BGZSYTZXDN(HXD)', 'BG注射用头孢西丁钠(海西丁)', '针剂', 'XYF', '瓶', '针剂', '63', '2g×1瓶');
INSERT INTO `medicine` VALUES ('BGZTZZFXRJ(DXRQ）', 'BG噻托溴铵粉吸入剂(带吸入器）', '粉剂', 'XYF', '盒', '粉剂', '24', '18ug×10粒/盒');
INSERT INTO `medicine` VALUES ('BHKL', '薄荷颗粒', '颗粒剂', 'ZCHYF', '袋', '颗粒剂', '67', '0.5g/6g/袋');
INSERT INTO `medicine` VALUES ('BJSN', '苯甲酸钠', '原料药', 'XYF', '袋', '原料药', '8', '500g×1袋');
INSERT INTO `medicine` VALUES ('BLDJZSY(NKL)', '胞磷胆碱注射液(尼可林)', '针剂', 'XYF', '盒', '针剂', '2', '2ml:0.25g×10支/盒');
INSERT INTO `medicine` VALUES ('BLFL', '百里酚兰', '原料药', 'XYF', '瓶', '原料药', '1', '25g×1瓶');
INSERT INTO `medicine` VALUES ('BLMJN', '百乐眠胶囊', '胶囊', 'ZCHYF', '盒', '胶囊', '15', '0.27g×24粒/盒');
INSERT INTO `medicine` VALUES ('BSZZJN(PFL)', '白芍总苷胶囊(帕夫林)', '胶囊', 'ZCHYF', '盒', '胶囊', '35', '0.3g×60粒/盒');
INSERT INTO `medicine` VALUES ('BXF', '保险粉', '原料药', 'XYF', '瓶', '原料药', '47', '500g×1瓶');
INSERT INTO `medicine` VALUES ('BZKL', '白芷颗粒', '颗粒剂', 'ZCHYF', '袋', '颗粒剂', '68', '1g/6g/袋');
INSERT INTO `medicine` VALUES ('BZRKL', '柏子仁颗粒', '颗粒剂', 'ZCHYF', '袋', '颗粒剂', '1', '0.5g/10g/袋');
INSERT INTO `medicine` VALUES ('BZTKL', '巴戢天颗粒', '颗粒剂', 'ZCHYF', '袋', '颗粒剂', '4', '3g/10g/袋');
INSERT INTO `medicine` VALUES ('CB', '川贝', '中药饮片', 'ZCYF', 'kg', '中药饮片', '20', '1000克/公斤');
INSERT INTO `medicine` VALUES ('CBSKL', '炒白芍颗粒', '颗粒剂', 'ZCHYF', '袋', '颗粒剂', '32', '1g/10g/袋');
INSERT INTO `medicine` VALUES ('CBY', '侧柏叶', '中药饮片', 'ZCYF', 'Kg', '中药饮片', '19', '1000克/公斤');
INSERT INTO `medicine` VALUES ('CCRBZSY(GN)', '长春瑞宾注射液(盖诺)', '针剂', 'XYF', '支', '针剂', '4', '10mg×1支');
INSERT INTO `medicine` VALUES ('CCXTLHNZSY(JLZ)', '*长春西汀氯化钠注射液(杰力纾)', '针剂', 'XYF', '瓶', '针剂', '30', '100ml:10mg×1瓶');
INSERT INTO `medicine` VALUES ('CD', '川断', '中药饮片', 'ZCYF', 'kg', '中药饮片', '44', '1000克/公斤');
INSERT INTO `medicine` VALUES ('CDKL', '川断颗粒', '颗粒剂', 'ZCHYF', '袋', '颗粒剂', '3', '2g/10g/袋');
INSERT INTO `medicine` VALUES ('CDX', '陈胆星', '中药饮片', 'ZCYF', 'kg', '中药饮片', '41', '1000克/公斤');
INSERT INTO `medicine` VALUES ('CEZ', '苍耳子', '中药饮片', 'ZCYF', 'Kg', '中药饮片', '3', '1000克/公斤');
INSERT INTO `medicine` VALUES ('CFKKL', '产复康颗粒', '颗粒剂', 'ZCHYF', '盒', '颗粒剂', '17', '5g*15袋/盒');
INSERT INTO `medicine` VALUES ('CGP', '椿根皮', '中药饮片', 'ZCYF', 'Kg', '中药饮片', '32', '1000克/公斤');
INSERT INTO `medicine` VALUES ('CHKL', '柴胡颗粒', '颗粒剂', 'ZCHYF', '袋', '颗粒剂', '22', '1g/6g/袋');
INSERT INTO `medicine` VALUES ('CJC', '炒僵蚕', '中药饮片', 'ZCYF', 'kg', '中药饮片', '9', '1000克/公斤');
INSERT INTO `medicine` VALUES ('CJCKL', '炒僵蚕颗粒', '颗粒剂', 'ZCHYF', '袋', '颗粒剂', '9', '1g/10g/袋');
INSERT INTO `medicine` VALUES ('CJHSJN(SEP)', '茶碱缓释胶囊(时尔平)', '胶囊', 'XYF', '盒', '胶囊', '26', '0.1g×24粒/盒');
INSERT INTO `medicine` VALUES ('CNX', '川牛夕', '中药饮片', 'ZCYF', 'Kg', '中药饮片', '19', '1000克/公斤');
INSERT INTO `medicine` VALUES ('CNYYRJTPF(RX)', '肠内营养乳剂TPF(瑞先)', '乳剂', 'XYF', '瓶', '乳剂', '51', '500ml×1瓶');
INSERT INTO `medicine` VALUES ('CNYYRJTPF-D(RD)', '肠内营养乳剂TPF-D(瑞代)', '乳剂', 'XYF', '袋', '乳剂', '30', '500ml×1袋');
INSERT INTO `medicine` VALUES ('CP', '陈皮', '中药饮片', 'ZCYF', 'kg', '中药饮片', '10', '1000克/公斤');
INSERT INTO `medicine` VALUES ('CPC', '垂盆草', '中药饮片', 'ZCYF', 'Kg', '中药饮片', '4', '1000克/公斤');
INSERT INTO `medicine` VALUES ('CPKL', '陈皮颗粒', '颗粒剂', 'ZCHYF', '袋', '颗粒剂', '1', '1g/6g/袋');
INSERT INTO `medicine` VALUES ('CQC', '车前草', '中药饮片', 'ZCYF', 'kg', '中药饮片', '8', '1000克/公斤');
INSERT INTO `medicine` VALUES ('CQZ', '车前子', '中药饮片', 'ZCYF', 'kg', '中药饮片', '53', '1000克/公斤');
INSERT INTO `medicine` VALUES ('CS', '磁石', '中药饮片', 'ZCYF', 'Kg', '中药饮片', '7', '1000克/公斤');
INSERT INTO `medicine` VALUES ('CSAQZZSY(LEN)', '醋酸奥曲肽注射液(力尔宁)', '针剂', 'XYF', '支', '针剂', '73', '1ml:0.2mg×1支');
INSERT INTO `medicine` VALUES ('CSASXTPLP(LSP）', '草酸艾司西酞普兰片(来士普）', '片剂', 'XYF', '盒', '片剂', '47', '10mg×7片/盒');
INSERT INTO `medicine` VALUES ('CSKL', '赤芍颗粒', '颗粒剂', 'ZCHYF', '袋', '颗粒剂', '62', '1.5g/10g/袋');
INSERT INTO `medicine` VALUES ('CSN', '醋酸钠', '原料药', 'XYF', '瓶', '原料药', '1', '1000g×1瓶');
INSERT INTO `medicine` VALUES ('CSYZ', '醋酸乙酯', '原料药', 'XYF', '瓶', '原料药', '48', '500g×1瓶');
INSERT INTO `medicine` VALUES ('CSZRKL', '炒酸枣仁颗粒', '颗粒剂', 'ZCHYF', '袋', '颗粒剂', '2', '0.5g/10g/袋');
INSERT INTO `medicine` VALUES ('CTHYZSY', '垂体后叶注射液', '针剂', 'XYF', '盒', '针剂', '43', '1ml:6iu×10支/盒');
INSERT INTO `medicine` VALUES ('CTSZ', '次碳酸铋', '原料药', 'XYF', '瓶', '原料药', '25', '500g×1瓶');
INSERT INTO `medicine` VALUES ('CW', '川乌', '中药饮片', 'ZCYF', 'Kg', '中药饮片', '10', '1000克/公斤');
INSERT INTO `medicine` VALUES ('CX', '沉香', '中药饮片', 'ZCYF', 'kg', '中药饮片', '23', '1000克/公斤');
INSERT INTO `medicine` VALUES ('CXFKL', '醋香附颗粒', '颗粒剂', 'ZCHYF', '袋', '颗粒剂', '21', '0.5g/10g/袋');
INSERT INTO `medicine` VALUES ('CYKFY', '柴银口服液', '口服液类', 'ZCHYF', '盒', '口服液类', '3', '20ml×6支/盒');
INSERT INTO `medicine` VALUES ('CZ', '川芎', '中药饮片', 'ZCYF', 'Kg', '中药饮片', '18', '1000克/公斤');
INSERT INTO `medicine` VALUES ('CZK', '炒枳壳', '中药饮片', 'ZCYF', 'kg', '中药饮片', '3', '1000克/公斤');
INSERT INTO `medicine` VALUES ('CZKKL(C)', '炒枳壳颗粒(麩炒)', '颗粒剂', 'ZCHYF', '袋', '颗粒剂', '8', '1g/6g/袋');
INSERT INTO `medicine` VALUES ('CZKL', '川芎颗粒', '颗粒剂', 'ZCHYF', '袋', '颗粒剂', '1', '2g/6g/袋');
INSERT INTO `medicine` VALUES ('CZP', '刺猬皮', '中药饮片', 'ZCYF', 'Kg', '中药饮片', '4', '1000克/公斤');
INSERT INTO `medicine` VALUES ('CZS', '炒枳实', '中药饮片', 'ZCYF', 'kg', '中药饮片', '84', '1000克/公斤');
INSERT INTO `medicine` VALUES ('CZT', '陈棕炭', '中药饮片', 'ZCYF', 'kg', '中药饮片', '27', '1000克/公斤');
INSERT INTO `medicine` VALUES ('CZZ', '川楝子', '中药饮片', 'ZCYF', 'Kg', '中药饮片', '4', '1000克/公斤');
INSERT INTO `medicine` VALUES ('DBZZSTKFRY', '蛋白琥珀酸铁口服溶液', '口服液类', 'XYF', '盒', '口服液类', '13', '15ml:40mg×10瓶/盒');
INSERT INTO `medicine` VALUES ('DC', '丹参', '中药饮片', 'ZCYF', 'Kg', '中药饮片', '22', '1000克/公斤');
INSERT INTO `medicine` VALUES ('DCTIIAHSNZSY', '丹参酮IIA磺酸钠注射液', '针剂', 'XYF', '支', '针剂', '63', '2ml:10mg×1支');
INSERT INTO `medicine` VALUES ('DCTJN', '丹参酮胶囊', '胶囊', 'XYF', '盒', '胶囊', '31', '0.25g×24粒/盒');
INSERT INTO `medicine` VALUES ('DFP', '大腹皮', '中药饮片', 'ZCYF', 'Kg', '中药饮片', '0', '1000克/公斤');
INSERT INTO `medicine` VALUES ('DFZ', '大枫子', '中药饮片', 'ZCYF', 'Kg', '中药饮片', '11', '1000克/公斤');
INSERT INTO `medicine` VALUES ('DFZGSGZSY(BZQ)', '低分子肝素钙注射液(博璞青)', '针剂', 'XYF', '支', '针剂', '11', '0.4ml4000u×1支');
INSERT INTO `medicine` VALUES ('DF（YX）', '碘伏（越星）', '原料药', 'XYF', '瓶', '原料药', '67', '60ml×1瓶');
INSERT INTO `medicine` VALUES ('DHC300ZSY(ONPK)', '碘海醇300注射液(欧乃派克)', '针剂', 'XYF', '瓶', '针剂', '5', '300mg×100ml/瓶');
INSERT INTO `medicine` VALUES ('DHC350ZSY(ONPK)', '碘海醇350注射液(欧乃派克)', '针剂', 'XYF', '瓶', '针剂', '14', '350mg×100ml/瓶');
INSERT INTO `medicine` VALUES ('DHJ', '碘化钾', '原料药', 'XYF', '瓶', '原料药', '53', '500克×1瓶');
INSERT INTO `medicine` VALUES ('DJ', '碘酊', '原料药', 'XYF', '瓶', '原料药', '27', '500mL/瓶');
INSERT INTO `medicine` VALUES ('DJC', '大蓟草', '中药饮片', 'ZCYF', 'Kg', '中药饮片', '42', '1000克/公斤');
INSERT INTO `medicine` VALUES ('DLLTD(ELS)P', '地氯雷他定(恩理思)片', '片剂', 'XYF', '盒', '片剂', '36', '5mg×6片/盒');
INSERT INTO `medicine` VALUES ('DPKL', '丹皮颗粒', '颗粒剂', 'ZCHYF', '袋', '颗粒剂', '3', '1g/6g/袋');
INSERT INTO `medicine` VALUES ('DQY', '大青叶', '中药饮片', 'ZCYF', 'Kg', '中药饮片', '73', '1000克/公斤');
INSERT INTO `medicine` VALUES ('DSMSLSNZSY', '地塞米松磷酸钠注射液', '针剂', 'XYF', '盒', '针剂', '29', '1ml:5mg×10支/盒');
INSERT INTO `medicine` VALUES ('DTJ', '单糖浆', '原料药', 'XYF', '瓶', '原料药', '47', '500ml×1瓶');
INSERT INTO `medicine` VALUES ('DTYDS(NHP)ZSY', '地特胰岛素(诺和平)注射液', '针剂', 'XYF', '支', '针剂', '8', '300iu/3ml/支');
INSERT INTO `medicine` VALUES ('DWYSP(SC)', '多维元素片(善存)', '片剂', 'XYF', '瓶', '片剂', '7', '60片/瓶');
INSERT INTO `medicine` VALUES ('DXLZXDJJN(YSF)', '多烯磷酯酰胆碱胶囊(易善复)', '胶囊', 'XYF', '盒', '胶囊', '17', '228mg×24粒/盒');
INSERT INTO `medicine` VALUES ('DXTSZSY(TSD)', '多西他赛注射液(泰索帝)', '针剂', 'XYF', '支', '针剂', '43', '20mg×1支');
INSERT INTO `medicine` VALUES ('DXZZSY(AD)', '地西泮注射液(安定)', '针剂', 'XYF', '盒', '针剂', '10', '2ml:10mg×10支/盒');
INSERT INTO `medicine` VALUES ('DYZSGYZ', '单硬脂酸甘油酯', '原料药', 'XYF', '瓶', '原料药', '30', '100g×1瓶');
INSERT INTO `medicine` VALUES ('DZS', '代赭石', '中药饮片', 'ZCYF', 'Kg', '中药饮片', '27', '1000克/公斤');
INSERT INTO `medicine` VALUES ('DZXCNYYHXYSP(BPL)', '短肽型肠内营养混悬液SP(百普力)', '口服液类', 'XYF', '瓶', '口服液类', '47', '500ml×1瓶');
INSERT INTO `medicine` VALUES ('DZXXZSY', '灯盏细辛注射液', '针剂', 'XYF', '盒', '针剂', '54', '10ml:45mg×2支/盒');
INSERT INTO `medicine` VALUES ('DZXZSY', '地佐辛注射液', '针剂', 'XYF', '支', '针剂', '79', '1ml:5mg×1支');
INSERT INTO `medicine` VALUES ('DZZJZSY', '东莨菪碱注射液', '针剂', 'XYF', '支', '针剂', '15', '1ml:0.3mg×1支');
INSERT INTO `medicine` VALUES ('D[125I]MFZY', '碘[125I]密封籽源', '针剂', 'XYF', '粒', '针剂', '5', '3.7-222MBq(0.1-6Mci)*1粒');
INSERT INTO `medicine` VALUES ('EBSTP(ABW)', '厄贝沙坦片(安博维)', '片剂', 'XYF', '盒', '片剂', '1', '150mg×7片/盒');
INSERT INTO `medicine` VALUES ('EBSTP（JJ）', '厄贝沙坦片（吉加）', '片剂', 'XYF', '盒', '片剂', '23', '150mg×14片/盒');
INSERT INTO `medicine` VALUES ('EBSTQLZZ(ABN)P', '厄贝沙坦氢氯噻嗪(安博诺)片', '片剂', 'XYF', '盒', '片剂', '55', '150mg×7片/盒');
INSERT INTO `medicine` VALUES ('ETKPP（ZD）', '恩他卡朋片（珂丹）', '片剂', 'XYF', '盒', '片剂', '39', '0.2g×30片/盒');
INSERT INTO `medicine` VALUES ('ETKWP(BLD)', '恩替卡韦片(博路定)', '片剂', 'XYF', '盒', '片剂', '29', '0.5mg×7片/盒');
INSERT INTO `medicine` VALUES ('EYXAYSYEAZSY(HKD)', '二乙酰氨乙酸乙二胺注射液(华克盾)', '针剂', 'XYF', '支', '针剂', '16', '5ml:0.3g×1支');
INSERT INTO `medicine` VALUES ('FFBTMSZSY(DBS)', '复方倍他米松注射液(得宝松)', '针剂', 'XYF', '支', '针剂', '10', '7mg×1支');
INSERT INTO `medicine` VALUES ('FFDCDW', '复方丹参滴丸', '丸剂', 'ZCHYF', '盒', '丸剂', '24', '27mg*180粒/盒');
INSERT INTO `medicine` VALUES ('FFJYECDJKFS', '复方聚乙二醇电解口服散', '散剂', 'XYF', '盒', '散剂', '18', 'ABC3包/盒');
INSERT INTO `medicine` VALUES ('FFLDKYRG', '复方利多卡因乳膏', '软膏剂', 'XYF', '支', '软膏剂', '6', '10g×1支');
INSERT INTO `medicine` VALUES ('FFTTNHSP(LSK)', '氟伐他汀钠缓释片(来适可)', '缓释片', 'XYF', '盒', '缓释片', '7', '80mg×7片/盒');
INSERT INTO `medicine` VALUES ('FFTZKADYY', '复方托吡卡胺滴眼液', '滴眼剂', 'XYF', '支', '滴眼剂', '5', '1mL/支');
INSERT INTO `medicine` VALUES ('FFZ（LFF）', '蜂房子（露蜂房）', '中药饮片', 'ZCYF', 'kg', '中药饮片', '3', '1000克/公斤');
INSERT INTO `medicine` VALUES ('FFα-TSP(KT)', '复方α-酮酸片(开同)', '片剂', 'XYF', '盒', '片剂', '6', '630mg×100片/盒');
INSERT INTO `medicine` VALUES ('FHLSQJZSY(WJL)', '复合磷酸氢钾注射液(唯甲林)', '针剂', 'XYF', '支', '针剂', '1', '2ml×1支');
INSERT INTO `medicine` VALUES ('FHYAZSY', '酚磺乙胺注射液', '针剂', 'XYF', '盒', '针剂', '6', '2ml:0.5g×10支/盒');
INSERT INTO `medicine` VALUES ('FKZLHNZSY(DFK)', '氟康唑氯化钠注射液(大扶康)', '针剂', 'XYF', '瓶', '针剂', '7', '200mg×100ml/瓶');
INSERT INTO `medicine` VALUES ('ZZZL(LYX)ZSY', '咪哒唑仑(力月西)注射液', '针剂', 'XYF', '支', '针剂', '21', '1ml:5mg×1支');
INSERT INTO `medicine` VALUES ('Z[99TC]YJJEZSYZSY(YK)', '锝[99TC]亚甲基二瞵酸盐注射液(云克)', '针剂', 'XYF', '盒', '针剂', '18', 'A5ml B5.5mg/盒');

-- ----------------------------
-- Table structure for `non_medic`
-- ----------------------------
DROP TABLE IF EXISTS `non_medic`;
CREATE TABLE `non_medic` (
  `itemcode` varchar(40) NOT NULL,
  `feecode` varchar(40) NOT NULL,
  `deptcode` varchar(40) NOT NULL,
  `nmedname` varchar(40) NOT NULL,
  `size` varchar(40) DEFAULT NULL,
  `price` double(20,0) NOT NULL,
  PRIMARY KEY (`itemcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of non_medic
-- ----------------------------
INSERT INTO `non_medic` VALUES ('(JB)JGJP', 'CTCLF', 'XEZXK', '(江北)激光胶片', '14*17', '50');
INSERT INTO `non_medic` VALUES ('(JB)YYGSJP', 'CTCLF', 'XEZXK', '(江北)医用干式胶片', 'DI-HL10*12', '9');
INSERT INTO `non_medic` VALUES ('CGZGNCX:CGZBPCX（MRSI）', 'MRIJCF', 'ZYGCK', '磁共振功能成像:磁共振波谱成像（MRSI）', null, '9');
INSERT INTO `non_medic` VALUES ('CGZGNCX:CGZBPFX（MRS）', 'MRIJCF', 'ZYGCK', '磁共振功能成像:磁共振波谱分析（MRS）', null, '6');
INSERT INTO `non_medic` VALUES ('CGZGNCX:CGZSCX（MRCP、MRM、MRU）', 'MRIJCF', 'ZYGCK', '磁共振功能成像:磁共振水成像（MRCP、MRM、MRU）', null, '5');
INSERT INTO `non_medic` VALUES ('CGZGNCX:CGZXZGNJC', 'MRIJCF', 'ZYGCK', '磁共振功能成像:磁共振心脏功能检查', null, '67');
INSERT INTO `non_medic` VALUES ('CGZNGNCX', 'MRIJCF', 'ZYGCK', '磁共振脑功能成像', null, '59');
INSERT INTO `non_medic` VALUES ('CGZPS（CT CQ≥1.5T，＜3.0T）', 'MRIJCF', 'XEZXK', '磁共振平扫（垂体 场强≥1.5T，＜3.0T）', '江北', '15');
INSERT INTO `non_medic` VALUES ('CGZPS（LN CQ≥1.5T，＜3.0T）', 'MRIJCF', 'ZYGCK', '磁共振平扫（颅脑 场强≥1.5T，＜3.0T）', null, '49');
INSERT INTO `non_medic` VALUES ('CGZPS（PQ CQ3.0TJYS）', 'MRIJCF', 'ZYGCK', '磁共振平扫（盆腔 场强3.0T及以上）', null, '22');
INSERT INTO `non_medic` VALUES ('CGZPS（PQ CQ≥1.5T，＜3.0T）', 'MRIJCF', 'XEZXK', '磁共振平扫（盆腔 场强≥1.5T，＜3.0T）', '江北', '17');
INSERT INTO `non_medic` VALUES ('CGZPS（SKGJ CQ3.0TJYS）', 'MRIJCF', 'ZYGCK', '磁共振平扫（双K关节 场强3.0T及以上）', null, '0');
INSERT INTO `non_medic` VALUES ('CGZPS（XZ CQ3.0TJYS）', 'MRIJCF', 'ZYGCK', '磁共振平扫（心脏 场强3.0T及以上）', null, '5');
INSERT INTO `non_medic` VALUES ('CGZPS（XZ CQ≥1.5T，＜3.0T）', 'MRIJCF', 'XEZXK', '磁共振平扫（心脏 场强≥1.5T，＜3.0T）', '江北', '6');
INSERT INTO `non_medic` VALUES ('CGZPS（YK CQ≥1.5T，＜3.0T）', 'MRIJCF', 'ZYGCK', '磁共振平扫（眼眶 场强≥1.5T，＜3.0T）', null, '66');
INSERT INTO `non_medic` VALUES ('CGZPS（ZFB CQ≥1.5T，＜3.0T）', 'MRIJCF', 'ZYGCK', '磁共振平扫（中腹部 场强≥1.5T，＜3.0T）', null, '22');
INSERT INTO `non_medic` VALUES ('CGZPS（ZGJ CQ3.0TJYS）', 'MRIJCF', 'ZYGCK', '磁共振平扫（肘关节 场强3.0T及以上）', null, '18');
INSERT INTO `non_medic` VALUES ('CGZPS（ZZGJ CQ≥1.5T，＜3.0T）', 'MRIJCF', 'XEZXK', '磁共振平扫（颞颌关节 场强≥1.5T，＜3.0T）', '江北', '21');
INSERT INTO `non_medic` VALUES ('CGZSYXDHHXMKSBJS', 'MRIJCF', 'ZYGCK', '磁共振使用心电或呼吸门控设备加收', null, '14');
INSERT INTO `non_medic` VALUES ('CGZZQSM（FBZ CQ3.0TJYS）', 'MRIJCF', 'XEZXK', '磁共振增强扫描（副鼻窦 场强3.0T及以上）', '江北', '25');
INSERT INTO `non_medic` VALUES ('CGZZQSM（HGJ CQ3.0TJYS）', 'MRIJCF', 'XEZXK', '磁共振增强扫描（H关节 场强3.0T及以上）', '江北', '38');
INSERT INTO `non_medic` VALUES ('CGZZQSM（JGJ CQ3.0TJYS）', 'MRIJCF', 'XEZXK', '磁共振增强扫描（肩关节 场强3.0T及以上）', '江北', '2');
INSERT INTO `non_medic` VALUES ('CGZZQSM（PQ CQ3.0TJYS）', 'MRIJCF', 'XEZXK', '磁共振增强扫描（盆腔 场强3.0T及以上）', '江北', '29');
INSERT INTO `non_medic` VALUES ('CGZZQSM（QLX CQ≥1.5T，＜3.0T）', 'MRIJCF', 'ZYGCK', '磁共振增强扫描（前列腺 场强≥1.5T，＜3.0T）', null, '24');
INSERT INTO `non_medic` VALUES ('CGZZQSM（RX CQ3.0TJYS）', 'MRIJCF', 'ZYGCK', '磁共振增强扫描（乳腺 场强3.0T及以上）', null, '1');
INSERT INTO `non_medic` VALUES ('CGZZQSM（SFB CQ3.0TJYS）', 'MRIJCF', 'ZYGCK', '磁共振增强扫描（上腹部 场强3.0T及以上）', null, '67');
INSERT INTO `non_medic` VALUES ('CGZZQSM（SKGJ CQ3.0TJYS）', 'MRIJCF', 'XEZXK', '磁共振增强扫描（双K关节 场强3.0T及以上）', '江北', '20');
INSERT INTO `non_medic` VALUES ('CGZZQSM（XGJ CQ≥1.5T，＜3.0T）', 'MRIJCF', 'ZYGCK', '磁共振增强扫描（膝关节 场强≥1.5T，＜3.0T）', null, '31');
INSERT INTO `non_medic` VALUES ('CGZZQSM（XZ CQ3.0TJYS）', 'MRIJCF', 'XEZXK', '磁共振增强扫描（心脏 场强3.0T及以上）', '江北', '3');
INSERT INTO `non_medic` VALUES ('CGZZQSM（ZZGJ CQ3.0TJYS）', 'MRIJCF', 'XEZXK', '磁共振增强扫描（颞颌关节 场强3.0T及以上）', '江北', '14');
INSERT INTO `non_medic` VALUES ('CJZXSSTKTCD（HXFGF、YGMYF）', 'JYF', 'XYNK', '促甲状腺素受体抗体测定（化X发光法、荧光免疫法）', '江北', '11');
INSERT INTO `non_medic` VALUES ('CTJP（DVBJP 14×17 KD）', 'CTCLF', 'XEZXK', 'CT胶片（DVB胶片 14×17 柯达）', 'DVB胶片 14×17 柯达', '1');
INSERT INTO `non_medic` VALUES ('CTPHZ', 'CTJCF', 'XYNK', 'CT片会诊', null, '45');
INSERT INTO `non_medic` VALUES ('DFTQMZ', 'MZF', 'KQK', '单肺通气麻醉', null, '8');
INSERT INTO `non_medic` VALUES ('DPLXCTPS（CZG）', 'CTJCF', 'XEZXK', '多排螺旋CT平扫（尺桡骨）', '江北', '50');
INSERT INTO `non_medic` VALUES ('DPLXCTPS（GG）', 'CTJCF', 'XEZXK', '多排螺旋CT平扫（股骨）', '江北', '57');
INSERT INTO `non_medic` VALUES ('DPLXCTPS（SKGJ）', 'CTJCF', 'XEZXK', '多排螺旋CT平扫（双K关节）', '江北', '0');
INSERT INTO `non_medic` VALUES ('DPLXCTPS（SXGJ）', 'CTJCF', 'XEZXK', '多排螺旋CT平扫（双膝关节）', '江北', '52');
INSERT INTO `non_medic` VALUES ('DPLXCTPS（S）', 'CTJCF', 'XEZXK', '多排螺旋CT平扫（手）', '江北', '70');
INSERT INTO `non_medic` VALUES ('DPLXCTPS（WGJ）', 'CTJCF', 'XEZXK', '多排螺旋CT平扫（腕关节）', '江北', '10');
INSERT INTO `non_medic` VALUES ('DPLXCTPS（ZGJ）', 'CTJCF', 'XYNK', '多排螺旋CT平扫（肘关节）', '江北', '28');
INSERT INTO `non_medic` VALUES ('DPLXCTPS（ZG）', 'CTJCF', 'XYNK', '多排螺旋CT平扫（肱骨）', '江北', '22');
INSERT INTO `non_medic` VALUES ('DPLXCTZQSM（HGJ）', 'CTJCF', 'XYNK', '多排螺旋CT增强扫描（H关节）', null, '41');
INSERT INTO `non_medic` VALUES ('DPLXCTZQSM（ZZG）', 'CTJCF', 'XYNK', '多排螺旋CT增强扫描（胫腓骨）', null, '10');
INSERT INTO `non_medic` VALUES ('DPLXCTZQSM（Z）', 'CTJCF', 'XYNK', '多排螺旋CT增强扫描（足）', null, '4');
INSERT INTO `non_medic` VALUES ('FBMZF', 'ZLF', 'XYNK', '方便门诊费', null, '1');
INSERT INTO `non_medic` VALUES ('FBZZY', 'FSJCF', 'ZYGCK', '副鼻窦造影', null, '36');
INSERT INTO `non_medic` VALUES ('FBZZYSCJS', 'FSJCF', 'ZYGCK', '副鼻窦造影双侧加收', null, '42');
INSERT INTO `non_medic` VALUES ('FZRMZZYBZLZF(LH)', 'ZLF', 'XYNK', '副主任门诊中医辨证论治费(六合)', null, '22');
INSERT INTO `non_medic` VALUES ('FZRYSMZZCF(FZD)', 'QT', 'KQK', '副主任医师门诊诊察费(复诊等)', null, '18');
INSERT INTO `non_medic` VALUES ('FZRYSMZZCF(LH)', 'ZLF', 'XYNK', '副主任医师门诊诊察费(六合)', null, '3');
INSERT INTO `non_medic` VALUES ('GJZJZLZXZJMZZCF', 'ZLF', 'XYNK', '高级专家诊疗中心专家门诊诊察费', null, '55');
INSERT INTO `non_medic` VALUES ('GJZJZLZXZJMZZCF1', 'ZLF', 'XYNK', '高级专家诊疗中心专家门诊诊察费1', null, '68');
INSERT INTO `non_medic` VALUES ('GJZJZLZXZJMZZCF2', 'ZLF', 'XYNK', '高级专家诊疗中心专家门诊诊察费2', null, '12');
INSERT INTO `non_medic` VALUES ('GJZJZLZXZJMZZCF3', 'ZLF', 'XYNK', '高级专家诊疗中心专家门诊诊察费3', null, '43');
INSERT INTO `non_medic` VALUES ('GJZJZLZXZJMZZCF4', 'ZLF', 'XYNK', '高级专家诊疗中心专家门诊诊察费4', null, '1');
INSERT INTO `non_medic` VALUES ('GJZJZLZXZJMZZCF6', 'ZLF', 'XYNK', '高级专家诊疗中心专家门诊诊察费6', null, '10');
INSERT INTO `non_medic` VALUES ('GMBDGBBQCS', 'MZSSF', 'ZYGCK', '肝门部胆管病变切除术', null, '11');
INSERT INTO `non_medic` VALUES ('HYTZJS', 'MZSSF', 'KQK', '会阴体重建术', null, '44');
INSERT INTO `non_medic` VALUES ('JXXWGRHS', 'MZSSF', 'ZYGCK', '局限性腕骨融合术', null, '4');
INSERT INTO `non_medic` VALUES ('JYDLCNZCCS', 'MZSSF', 'ZYGCK', '经阴道卵巢囊肿穿刺术', null, '63');
INSERT INTO `non_medic` VALUES ('JYJJY', 'QT', 'KQK', '煎药机煎药', '江北', '14');
INSERT INTO `non_medic` VALUES ('JZH', 'GHF', 'CWK', '急诊号', null, '70');
INSERT INTO `non_medic` VALUES ('JZZCF', 'ZLF', 'XYNK', '急诊诊察费', null, '65');
INSERT INTO `non_medic` VALUES ('JZZCF(LH)', 'ZLF', 'XYNK', '急诊诊察费(六合)', null, '10');
INSERT INTO `non_medic` VALUES ('KC1qKTCD(MLMYF)(DLCD)', 'JYF', 'XYNK', '抗C1q抗体测定(酶联免疫法)(定量测定)', null, '15');
INSERT INTO `non_medic` VALUES ('KFFQBBHJS(X)', 'MZSSF', 'ZYGCK', '开腹腹腔病变活检术(新)', null, '29');
INSERT INTO `non_medic` VALUES ('KLZMA2STKTJC', 'JYF', 'XYNK', '抗磷脂酶A2受体抗体检测', null, '61');
INSERT INTO `non_medic` VALUES ('KZXJY', 'MZSSF', 'ZYGCK', '控制性降压', null, '11');
INSERT INTO `non_medic` VALUES ('KαBCDBKTCD(MLMYF)(DLCD)', 'JYF', 'XYNK', '抗α胞衬蛋白抗体测定(酶联免疫法)(定量测定)', null, '19');
INSERT INTO `non_medic` VALUES ('LCCZDCTYD', 'CTJCF', 'XYNK', '临床操作的CT引导', null, '58');
INSERT INTO `non_medic` VALUES ('LDZY', 'FSJCF', 'ZYGCK', '泪道造影', null, '10');
INSERT INTO `non_medic` VALUES ('LDZYSCJS', 'FSJCF', 'ZYGCK', '泪道造影双侧加收', null, '44');
INSERT INTO `non_medic` VALUES ('LXCTSYXDHHXMKSBDJS', 'CTJCF', 'XYNK', '螺旋CT使用心电或呼吸门控设备的加收', null, '45');
INSERT INTO `non_medic` VALUES ('MJZLGZCF', 'ZLF', 'XYNK', '门急诊留观诊察费', null, '63');
INSERT INTO `non_medic` VALUES ('MRIPHZ', 'MRIJCF', 'ZYGCK', 'MRI片会诊', null, '36');
INSERT INTO `non_medic` VALUES ('MZZJC（HQMMZYND）', 'MZF', 'KQK', '麻醉中监测（呼气末麻醉药浓度）', null, '8');
INSERT INTO `non_medic` VALUES ('MZZJC（JS）', 'MZF', 'KQK', '麻醉中监测（肌松）', null, '3');
INSERT INTO `non_medic` VALUES ('MZZJC（MBYBHD）', 'MZF', 'KQK', '麻醉中监测（脉搏氧饱和度）', null, '37');
INSERT INTO `non_medic` VALUES ('MZZJC（STDFX）', 'MZF', 'KQK', '麻醉中监测（ST段分析）', null, '10');
INSERT INTO `non_medic` VALUES ('MZZJC（TW）', 'MZF', 'KQK', '麻醉中监测（体温）', null, '14');
INSERT INTO `non_medic` VALUES ('MZZJC（WCXY）', 'MZF', 'KQK', '麻醉中监测（无创X压）', null, '9');
INSERT INTO `non_medic` VALUES ('MZZJC（XDT）', 'MZF', 'KQK', '麻醉中监测（心电图）', null, '37');
INSERT INTO `non_medic` VALUES ('MZZJC（XLBYFX）', 'MZF', 'KQK', '麻醉中监测（心率变异分析）', null, '26');
INSERT INTO `non_medic` VALUES ('NYFX(GHXF)', 'JYF', 'XYNK', '尿液分析(干化X法)', '江北', '22');
INSERT INTO `non_medic` VALUES ('Nα1WLQDBCD（HXFGF）', 'JYF', 'XYNK', '尿α1微量球蛋白测定（化X发光法）', null, '47');
INSERT INTO `non_medic` VALUES ('PTH', 'GHF', 'CWK', '普通号', null, '5');
INSERT INTO `non_medic` VALUES ('PTMZZCF', 'ZLF', 'XYNK', '普通门诊诊察费', null, '41');
INSERT INTO `non_medic` VALUES ('PTMZZCF(LH)', 'ZLF', 'XYNK', '普通门诊诊察费(六合)', null, '13');
INSERT INTO `non_medic` VALUES ('PTMZZCF(YBYZZY)', 'QT', 'KQK', '普通门诊诊察费(医保义诊专用)', null, '89');
INSERT INTO `non_medic` VALUES ('PTMZZYBZLZF(LH)', 'ZLF', 'XYNK', '普通门诊中医辨证论治费(六合)', null, '3');
INSERT INTO `non_medic` VALUES ('RMYQXBDKTCD(Anti-HIV)（YJF、MMF、', 'JYF', 'XYNK', '人免疫缺陷病毒抗体测定(Anti-HIV)（印迹法、酶免法、', '江北', '6');
INSERT INTO `non_medic` VALUES ('RXDGZY', 'FSJCF', 'ZYGCK', '乳腺导管造影', null, '10');
INSERT INTO `non_medic` VALUES ('SBZJGJTWQKFWNGDS', 'MZSSF', 'ZYGCK', '手部指间关节脱位切开复位内固定术', null, '18');
INSERT INTO `non_medic` VALUES ('SMYHCCTZQ（GYZSQ、LJG、ZTD）', 'CTCLF', 'XEZXK', '扫描用耗材CT增强（高压注射器、连接管、针头等）', '江北', '52');
INSERT INTO `non_medic` VALUES ('SYBZSYRJJS', 'MZSSF', 'KQK', '使用膀胱肾盂软镜加收', null, '58');
INSERT INTO `non_medic` VALUES ('SZHSY(DR)', 'FSJCF', 'ZYGCK', '数字化摄影(DR)', '江北', '23');
INSERT INTO `non_medic` VALUES ('TWXH', 'MZSSF', 'ZYGCK', '体外X环', null, '3');
INSERT INTO `non_medic` VALUES ('TWXHJS', 'MZSSF', 'ZYGCK', '体外X环加收', null, '14');
INSERT INTO `non_medic` VALUES ('WGJRHS', 'MZSSF', 'ZYGCK', '腕关节融合术', null, '56');
INSERT INTO `non_medic` VALUES ('XQJSJM－MBTGMHXCD（GHXF）', 'JYF', 'XYNK', 'X清肌酸激酶－MB同工酶活性测定（干化X法）', null, '36');
INSERT INTO `non_medic` VALUES ('XQJSJM－MBTGMHXCD（JBF）', 'JYF', 'XYNK', 'X清肌酸激酶－MB同工酶活性测定（金标法）', null, '2');
INSERT INTO `non_medic` VALUES ('XSZFTSJTDYDLCYXZJZCF', 'ZLF', 'XYNK', '享受政府特殊津贴待遇的临床医X专家诊察费', null, '29');
INSERT INTO `non_medic` VALUES ('XSZFTSJTDYDLCYXZJZCF(LH)', 'ZLF', 'XYNK', '享受政府特殊津贴待遇的临床医X专家诊察费(六合)', null, '53');
INSERT INTO `non_medic` VALUES ('XXJSJTC(CT)CX', 'CTJCF', 'XYNK', 'X线计算机体层(CT)成象', null, '26');
INSERT INTO `non_medic` VALUES ('XXKTXJCD(IgGKA)', 'JYF', 'XYNK', 'X型抗体效价测定(IgG抗A)', '江北', '16');
INSERT INTO `non_medic` VALUES ('XXPHZ', 'FSJCF', 'ZYGCK', 'X线片会诊', '江北', '2');
INSERT INTO `non_medic` VALUES ('YDFBS(X)', 'MZSSF', 'KQK', '阴道封闭术(新)', null, '31');
INSERT INTO `non_medic` VALUES ('YEYF（D）', 'QT', 'KQK', '婴儿衣服（冬）', '江北', '2');
INSERT INTO `non_medic` VALUES ('YEYF（X）', 'QT', 'KQK', '婴儿衣服（夏）', '江北', '36');
INSERT INTO `non_medic` VALUES ('YJBSJMJZS', 'MZSSF', 'ZYGCK', '阴茎背深静脉结扎术', null, '24');
INSERT INTO `non_medic` VALUES ('YJHMTJMJZS', 'MZSSF', 'ZYGCK', '阴茎海绵体静脉结扎术', null, '26');
INSERT INTO `non_medic` VALUES ('YKGZNGDXFS(X)', 'MZSSF', 'ZYGCK', '眼眶骨折内固定修复术(新)', null, '6');
INSERT INTO `non_medic` VALUES ('YWYXXHZ', 'FSJCF', 'ZYGCK', '院外影像X会诊', '江北', '3');
INSERT INTO `non_medic` VALUES ('ZJGJRHS', 'MZSSF', 'ZYGCK', '指间关节融合术', null, '38');
INSERT INTO `non_medic` VALUES ('ZJH', 'GHF', 'CWK', '专家号', null, '50');
INSERT INTO `non_medic` VALUES ('ZQGZY', 'FSJCF', 'ZYGCK', '支气管造影', null, '1');
INSERT INTO `non_medic` VALUES ('ZQGZYSCJS', 'FSJCF', 'ZYGCK', '支气管造影双侧加收', null, '60');
INSERT INTO `non_medic` VALUES ('ZRMZZYBZLZF(LH)', 'ZLF', 'XYNK', '主任门诊中医辨证论治费(六合)', null, '3');
INSERT INTO `non_medic` VALUES ('ZRYSMZZCF', 'ZLF', 'XYNK', '主任医师门诊诊察费', null, '61');
INSERT INTO `non_medic` VALUES ('ZRYSMZZCF(LH)', 'ZLF', 'XYNK', '主任医师门诊诊察费(六合)', null, '21');
INSERT INTO `non_medic` VALUES ('ZRYSMZZCF（FZD）', 'QT', 'KQK', '主任医师门诊诊察费（复诊等）', null, '57');
INSERT INTO `non_medic` VALUES ('ZSMYXJYKTPJC(MYYJF)', 'JYF', 'XYNK', '自身免疫性肌炎抗体谱检测(免疫印迹法)', null, '35');
INSERT INTO `non_medic` VALUES ('ZWBZLQCS(X)', 'MZSSF', 'ZYGCK', 'Z尾部肿瘤切除术(新)', null, '3');
INSERT INTO `non_medic` VALUES ('ZXZGJZY', 'FSJCF', 'ZYGCK', '颞下颌关节造影', null, '19');
INSERT INTO `non_medic` VALUES ('ZXZGJZYSCJS', 'FSJCF', 'ZYGCK', '颞下颌关节造影双侧加收', null, '81');
INSERT INTO `non_medic` VALUES ('β2WQDBCD（GZMYXFF）', 'JYF', 'XYNK', 'β2微球蛋白测定（各种免疫X方法）', '江北', '30');

-- ----------------------------
-- Table structure for `patient`
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `pid` int(10) NOT NULL,
  `pname` varchar(40) NOT NULL,
  `pgender` tinyint(1) NOT NULL,
  `page` int(10) NOT NULL,
  `pbirth` date NOT NULL,
  `paddress` varchar(100) NOT NULL,
  `state` varchar(40) NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of patient
-- ----------------------------

-- ----------------------------
-- Table structure for `prerel`
-- ----------------------------
DROP TABLE IF EXISTS `prerel`;
CREATE TABLE `prerel` (
  `preRelid` int(10) NOT NULL AUTO_INCREMENT,
  `itemcode` varchar(40) NOT NULL,
  `preid` int(10) NOT NULL,
  PRIMARY KEY (`preRelid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prerel
-- ----------------------------

-- ----------------------------
-- Table structure for `prescription`
-- ----------------------------
DROP TABLE IF EXISTS `prescription`;
CREATE TABLE `prescription` (
  `preid` int(10) NOT NULL AUTO_INCREMENT,
  `pid` int(10) NOT NULL,
  `uRid` int(10) NOT NULL,
  `tempid` int(10) DEFAULT NULL,
  `pretype` varchar(40) NOT NULL,
  `state` varchar(40) NOT NULL,
  PRIMARY KEY (`preid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prescription
-- ----------------------------

-- ----------------------------
-- Table structure for `receipt`
-- ----------------------------
DROP TABLE IF EXISTS `receipt`;
CREATE TABLE `receipt` (
  `recid` int(10) NOT NULL,
  `recstate` varchar(40) NOT NULL,
  `operation` varchar(40) NOT NULL,
  `date` date NOT NULL,
  `uRid` int(10) NOT NULL,
  `feecode` varchar(40) NOT NULL,
  `chargerid` int(10) NOT NULL,
  PRIMARY KEY (`recid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of receipt
-- ----------------------------

-- ----------------------------
-- Table structure for `register`
-- ----------------------------
DROP TABLE IF EXISTS `register`;
CREATE TABLE `register` (
  `regid` int(10) NOT NULL AUTO_INCREMENT,
  `newRecord` tinyint(1) NOT NULL,
  `order` int(10) NOT NULL,
  `pid` int(10) NOT NULL,
  `uRid` int(10) NOT NULL,
  `itemcode` varchar(40) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`regid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of register
-- ----------------------------

-- ----------------------------
-- Table structure for `rule`
-- ----------------------------
DROP TABLE IF EXISTS `rule`;
CREATE TABLE `rule` (
  `ruleid` int(10) NOT NULL AUTO_INCREMENT,
  `rulename` varchar(40) NOT NULL,
  `uRid` int(10) NOT NULL,
  `timecode` varchar(40) NOT NULL,
  `reglevel` varchar(40) NOT NULL,
  `ration` int(10) NOT NULL,
  PRIMARY KEY (`ruleid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rule
-- ----------------------------
INSERT INTO `rule` VALUES ('1', 'max产科', '1', '00000000001100', '专家号', '100');
INSERT INTO `rule` VALUES ('2', 'hzh艾滋病科', '6', '01101101001100', '专家号', '50');
INSERT INTO `rule` VALUES ('3', 'max产前检查科', '4', '00000000000011', '普通号', '50');
INSERT INTO `rule` VALUES ('4', 'hzh产科', '7', '00000100000111', '普通号', '100');
INSERT INTO `rule` VALUES ('6', 'max干他', '1', '11111100000000', '普通号', '78');
INSERT INTO `rule` VALUES ('7', 'max产前抑郁', '4', '00001111000011', '急诊号', '67');

-- ----------------------------
-- Table structure for `shift`
-- ----------------------------
DROP TABLE IF EXISTS `shift`;
CREATE TABLE `shift` (
  `shiftid` int(10) NOT NULL AUTO_INCREMENT,
  `uRid` int(10) NOT NULL,
  `userid` int(10) NOT NULL,
  `balance` int(10) NOT NULL,
  `ration` int(10) NOT NULL,
  `itemcode` varchar(40) NOT NULL,
  `dutydate` date NOT NULL,
  `aorp` tinyint(1) NOT NULL,
  PRIMARY KEY (`shiftid`)
) ENGINE=InnoDB AUTO_INCREMENT=144 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shift
-- ----------------------------
INSERT INTO `shift` VALUES ('78', '7', '12', '100', '100', 'PTH', '2019-05-10', '0');
INSERT INTO `shift` VALUES ('79', '7', '12', '100', '100', 'PTH', '2019-05-11', '1');
INSERT INTO `shift` VALUES ('80', '7', '12', '100', '100', 'PTH', '2019-05-11', '0');
INSERT INTO `shift` VALUES ('81', '1', '12', '78', '78', 'PTH', '2019-05-21', '1');
INSERT INTO `shift` VALUES ('82', '1', '12', '78', '78', 'PTH', '2019-05-21', '0');
INSERT INTO `shift` VALUES ('83', '1', '12', '78', '78', 'PTH', '2019-05-26', '1');
INSERT INTO `shift` VALUES ('84', '1', '12', '78', '78', 'PTH', '2019-05-26', '0');
INSERT INTO `shift` VALUES ('85', '1', '12', '78', '78', 'PTH', '2019-05-27', '1');
INSERT INTO `shift` VALUES ('86', '1', '12', '78', '78', 'PTH', '2019-05-27', '0');
INSERT INTO `shift` VALUES ('87', '1', '12', '78', '78', 'PTH', '2019-05-28', '1');
INSERT INTO `shift` VALUES ('88', '1', '12', '78', '78', 'PTH', '2019-05-28', '0');
INSERT INTO `shift` VALUES ('89', '1', '12', '78', '78', 'PTH', '2019-06-02', '1');
INSERT INTO `shift` VALUES ('90', '1', '12', '78', '78', 'PTH', '2019-06-02', '0');
INSERT INTO `shift` VALUES ('91', '1', '12', '78', '78', 'PTH', '2019-06-03', '1');
INSERT INTO `shift` VALUES ('92', '1', '12', '78', '78', 'PTH', '2019-06-03', '0');
INSERT INTO `shift` VALUES ('93', '1', '12', '78', '78', 'PTH', '2019-06-04', '1');
INSERT INTO `shift` VALUES ('94', '1', '12', '78', '78', 'PTH', '2019-06-04', '0');
INSERT INTO `shift` VALUES ('95', '1', '12', '78', '78', 'PTH', '2019-06-09', '1');
INSERT INTO `shift` VALUES ('96', '1', '12', '78', '78', 'PTH', '2019-06-09', '0');
INSERT INTO `shift` VALUES ('97', '1', '12', '78', '78', 'PTH', '2019-06-10', '1');
INSERT INTO `shift` VALUES ('98', '1', '12', '78', '78', 'PTH', '2019-06-10', '0');
INSERT INTO `shift` VALUES ('99', '1', '12', '78', '78', 'PTH', '2019-06-11', '1');
INSERT INTO `shift` VALUES ('100', '1', '12', '78', '78', 'PTH', '2019-06-11', '0');
INSERT INTO `shift` VALUES ('101', '1', '12', '78', '78', 'PTH', '2019-06-16', '1');
INSERT INTO `shift` VALUES ('102', '1', '12', '78', '78', 'PTH', '2019-06-16', '0');
INSERT INTO `shift` VALUES ('103', '1', '12', '78', '78', 'PTH', '2019-06-17', '1');
INSERT INTO `shift` VALUES ('104', '1', '12', '78', '78', 'PTH', '2019-06-17', '0');
INSERT INTO `shift` VALUES ('105', '1', '12', '78', '78', 'PTH', '2019-06-18', '1');
INSERT INTO `shift` VALUES ('106', '1', '12', '78', '78', 'PTH', '2019-06-18', '0');
INSERT INTO `shift` VALUES ('107', '7', '12', '100', '100', 'PTH', '2019-05-21', '0');
INSERT INTO `shift` VALUES ('108', '7', '12', '100', '100', 'PTH', '2019-05-24', '0');
INSERT INTO `shift` VALUES ('109', '7', '12', '100', '100', 'PTH', '2019-05-25', '1');
INSERT INTO `shift` VALUES ('110', '7', '12', '100', '100', 'PTH', '2019-05-25', '0');
INSERT INTO `shift` VALUES ('112', '7', '12', '100', '100', 'PTH', '2019-05-31', '0');
INSERT INTO `shift` VALUES ('113', '7', '12', '100', '100', 'PTH', '2019-06-01', '1');
INSERT INTO `shift` VALUES ('114', '7', '12', '100', '100', 'PTH', '2019-06-01', '0');
INSERT INTO `shift` VALUES ('115', '7', '12', '100', '100', 'PTH', '2019-06-04', '0');
INSERT INTO `shift` VALUES ('116', '7', '12', '100', '100', 'PTH', '2019-06-07', '0');
INSERT INTO `shift` VALUES ('117', '7', '12', '100', '100', 'PTH', '2019-06-08', '1');
INSERT INTO `shift` VALUES ('118', '7', '12', '100', '100', 'PTH', '2019-06-08', '0');
INSERT INTO `shift` VALUES ('119', '7', '12', '100', '100', 'PTH', '2019-06-11', '0');
INSERT INTO `shift` VALUES ('120', '7', '12', '100', '100', 'PTH', '2019-06-14', '0');
INSERT INTO `shift` VALUES ('121', '7', '12', '100', '100', 'PTH', '2019-06-15', '1');
INSERT INTO `shift` VALUES ('122', '7', '12', '100', '100', 'PTH', '2019-06-15', '0');
INSERT INTO `shift` VALUES ('123', '7', '12', '100', '100', 'PTH', '2019-06-18', '0');
INSERT INTO `shift` VALUES ('126', '1', '12', '100', '100', 'ZJH', '2019-05-31', '1');
INSERT INTO `shift` VALUES ('127', '1', '12', '100', '100', 'ZJH', '2019-05-31', '0');
INSERT INTO `shift` VALUES ('128', '1', '12', '100', '100', 'ZJH', '2019-06-07', '1');
INSERT INTO `shift` VALUES ('129', '1', '12', '100', '100', 'ZJH', '2019-06-07', '0');
INSERT INTO `shift` VALUES ('130', '1', '12', '100', '100', 'ZJH', '2019-06-14', '1');
INSERT INTO `shift` VALUES ('131', '1', '12', '100', '100', 'ZJH', '2019-06-14', '0');
INSERT INTO `shift` VALUES ('132', '1', '123', '100', '100', 'ZJH', '2019-05-03', '1');
INSERT INTO `shift` VALUES ('133', '1', '123', '100', '100', 'ZJH', '2019-05-03', '0');
INSERT INTO `shift` VALUES ('134', '1', '123', '78', '78', 'PTH', '2019-05-05', '1');
INSERT INTO `shift` VALUES ('135', '1', '123', '78', '78', 'PTH', '2019-05-05', '0');
INSERT INTO `shift` VALUES ('136', '1', '123', '78', '78', 'PTH', '2019-05-06', '1');
INSERT INTO `shift` VALUES ('137', '1', '123', '78', '78', 'PTH', '2019-05-06', '0');
INSERT INTO `shift` VALUES ('138', '1', '123', '78', '78', 'PTH', '2019-05-07', '1');
INSERT INTO `shift` VALUES ('139', '1', '123', '78', '78', 'PTH', '2019-05-07', '0');
INSERT INTO `shift` VALUES ('140', '7', '123', '100', '100', 'PTH', '2019-05-03', '0');
INSERT INTO `shift` VALUES ('141', '7', '123', '100', '100', 'PTH', '2019-05-04', '1');
INSERT INTO `shift` VALUES ('142', '7', '123', '100', '100', 'PTH', '2019-05-04', '0');
INSERT INTO `shift` VALUES ('143', '7', '123', '100', '100', 'PTH', '2019-05-07', '0');

-- ----------------------------
-- Table structure for `template`
-- ----------------------------
DROP TABLE IF EXISTS `template`;
CREATE TABLE `template` (
  `tempid` int(10) NOT NULL AUTO_INCREMENT,
  `tempname` varchar(40) NOT NULL,
  `temptype` varchar(40) NOT NULL,
  `state` varchar(40) NOT NULL,
  PRIMARY KEY (`tempid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of template
-- ----------------------------

-- ----------------------------
-- Table structure for `temprel`
-- ----------------------------
DROP TABLE IF EXISTS `temprel`;
CREATE TABLE `temprel` (
  `tempRelid` int(10) NOT NULL AUTO_INCREMENT,
  `tempid` int(10) NOT NULL,
  `itemcode` varchar(40) NOT NULL,
  PRIMARY KEY (`tempRelid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of temprel
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `pwd` varchar(40) NOT NULL,
  `realname` varchar(40) NOT NULL,
  `usercat` varchar(40) NOT NULL,
  `position` varchar(40) DEFAULT NULL,
  `shiftOrNot` tinyint(4) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'max', '123', '孙宁远', '门诊医生', '主任医师', '1');
INSERT INTO `user` VALUES ('2', 'sama', '123', '汪凯君', '医技医生', '', '0');
INSERT INTO `user` VALUES ('3', 'phoenix', '123', '冯淇奎', '财务管理员', '', '0');
INSERT INTO `user` VALUES ('4', 'root', '123', '管理员', '医院管理员', null, '0');
INSERT INTO `user` VALUES ('5', 'reek', '123', '韩子豪', '门诊医生', '主任医师', '1');
INSERT INTO `user` VALUES ('32', '巨化股份', '123', '深入贯彻v', '门诊医生', '副主任医师', '1');

-- ----------------------------
-- Table structure for `userrdept`
-- ----------------------------
DROP TABLE IF EXISTS `userrdept`;
CREATE TABLE `userrdept` (
  `uRid` int(10) NOT NULL AUTO_INCREMENT,
  `userid` int(10) NOT NULL,
  `deptcode` varchar(40) NOT NULL,
  PRIMARY KEY (`uRid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userrdept
-- ----------------------------
INSERT INTO `userrdept` VALUES ('2', '2', 'XDTK');
INSERT INTO `userrdept` VALUES ('3', '3', 'CWK');
INSERT INTO `userrdept` VALUES ('5', '4', 'YYGLK');
INSERT INTO `userrdept` VALUES ('12', '5', 'CK');
INSERT INTO `userrdept` VALUES ('13', '32', 'CRK');
INSERT INTO `userrdept` VALUES ('14', '32', 'EKZH');
INSERT INTO `userrdept` VALUES ('15', '1', 'BTFYK');
INSERT INTO `userrdept` VALUES ('16', '1', 'CK');
INSERT INTO `userrdept` VALUES ('17', '1', 'CQJCK');
