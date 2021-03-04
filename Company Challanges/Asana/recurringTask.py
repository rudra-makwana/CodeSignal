import datetime
import calendar

def recurringTask(firstDate, k, daysOfTheWeek, n):
    dic = {}
    while(n>0):
        firstDay = datetime.datetime.strptime(firstDate, '%d/%m/%Y').weekday()
        if(calendar.day_name[firstDay] in daysOfTheWeek):
            if(calendar.day_name[firstDay] not in dic.keys()):
                dic[calendar.day_name[firstDay]] = [firstDate]
                n -= 1
            if(str((datetime.datetime.strptime(firstDate, '%d/%m/%Y') + datetime.timedelta(days=k*-7)).strftime('%d/%m/%Y')) in dic[calendar.day_name[firstDay]]):
                dic[calendar.day_name[firstDay]].append(firstDate)
                n -= 1
        firstDate = str((datetime.datetime.strptime(firstDate, '%d/%m/%Y') + datetime.timedelta(days=1)).strftime('%d/%m/%Y'))
    
    
    res = []
    for i in dic:
        res = res + dic[i]
        
    res.sort(key=lambda date: datetime.datetime.strptime(date,'%d/%m/%Y'))
    return res