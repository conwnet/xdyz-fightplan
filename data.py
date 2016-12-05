import sqlite3, random


def main():
    db = sqlite3.connect('data.db')
    #sql = """create table `person` (`id` integer primary key autoincrement, `name` text, `town` text, `village` text, `home` text, `relation_with_host` text, `health_status` text, `culture_status` text, `tel_number` text, `political_status` text, `poor_property` text, `poor_reason` text, `remark` text)"""
    #db.executescript(sql)
    villages = ['新立屯村', '双榆树村', '一间楼村', '贾家屯村', '腰营子村', '大石桥村', '莲花山村', '公立亨村', '东大门村', '冷家店村']
    names = '赵钱孙李周吴郑王冯陈楚卫蒋沈韩杨朱秦尤许何律师张常用字是指中文中经常用到的汉字将大学志愿从一本到专科总共八个志愿全部填成中央戏剧学院在全国各大院线正式下线'
    cultures = ['文盲', '小学', '初中', '高中', '大专以上']
    relations = ['姐姐', '妹妹', '弟弟', '儿子']
    properties = ['一般贫困户', '低保户']
    healths = ['一般疾病', '大病', '残疾']
    politicals = ['中共党员', '其他']
    reasons = ['因病', '因残', '因学', '缺土地', '缺水', '缺技术', '缺劳力', '缺资金', '交通条件落后', '自身发展动力不足', '因灾', '因婚']
    for i in range(300):
        village = villages[int(random.random() * len(villages))]
        name = names[int(random.random() * len(names))]
        name += names[int(random.random() * len(names))]
        name += names[int(random.random() * len(names))]
        culture_status = cultures[int(random.random() * len(cultures))]
        poor_property = properties[int(random.random() * len(properties))]
        health_status = healths[int(random.random() * len(healths))]
        political_status = politicals[int(random.random() * len(politicals))]
        poor_reason = reasons[int(random.random() * len(reasons))]
        sql = "insert into `person` (`name`, `town`, `village`, `home`, `relation_with_host`, `health_status`, `culture_status`, `tel_number`, `political_status`, `poor_property`, `poor_reason`, `remark`) values ('%s', '小德营子乡', '%s', '%s', '户主', '%s', '%s', '13012345678', '%s', '%s', '%s', '')" % (name, village, name, health_status, culture_status, political_status, poor_property, poor_reason)
        db.execute(sql)
        home = name
        name = names[int(random.random() * len(names))]
        name += names[int(random.random() * len(names))]
        name += names[int(random.random() * len(names))]
        culture_status = cultures[int(random.random() * len(cultures))]
        culture_status = cultures[int(random.random() * len(cultures))]
        poor_property = properties[int(random.random() * len(properties))]
        health_status = healths[int(random.random() * len(healths))]
        relation_with_host = relations[int(random.random() * len(relations))]
        sql = "insert into `person` (`name`, `town`, `village`, `home`, `relation_with_host`, `health_status`, `culture_status`, `tel_number`, `political_status`, `poor_property`, `poor_reason`, `remark`) values ('%s', '小德营子乡', '%s', '%s', '%s', '%s', '%s', '13012345678', '%s', '%s', '%s', '')" % (name, village, home, relation_with_host, health_status, culture_status, political_status, poor_property, poor_reason)
        db.execute(sql)
    db.commit()

if __name__ == '__main__':
    main()
    print('ok')

				
