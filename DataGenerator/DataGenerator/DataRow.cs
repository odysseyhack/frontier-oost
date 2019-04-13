namespace DataGenerator
{
    public class DataRow
    {
       // HourOfDay	DayOfWeek	WeekOfYear	Month	SolarSurface	AvgGenArea	Consumed	UvIndex	GeneratedSolar
       public int HourOfDay { get; set; }

       public int DayOfWeek { get; set; }

       public int WeekOfYear { get; set; }

       public int Month { get; set; }

       public decimal SolarSurface { get; set; }

       public decimal AvgGenArea { get; set; }

       public decimal Consumed { get;set; }

       public decimal UvIndex { get; set; }

       public decimal GeneratedSolar { get; set; }

       public override string ToString()
       {
           return $"{HourOfDay}\t{DayOfWeek}\t{WeekOfYear}\t{Month}\t{SolarSurface.ToString("F")}\t{AvgGenArea.ToString("F")}\t{Consumed.ToString("F")}\t{UvIndex.ToString("F")}\t{GeneratedSolar.ToString("F")}";
       }
    }
}