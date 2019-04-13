using System;
using System.Collections.Generic;
using System.Globalization;
using System.IO;

namespace DataGenerator
{
    class Program
    {
        static void Main()
        {
            CultureInfo.CurrentCulture = CultureInfo.InvariantCulture;

            var csv = File.Open("out.csv", FileMode.Create);
            var writer = new StreamWriter(csv);
            var r = new Random();

            var januaryFirst = new DateTime(2019, 1, 1);
            var surfaces = new Dictionary<int, decimal>();
            for (int i = 0; i < 10; i++)
            {
                surfaces[i] = r.Next(8, 20);
            }

            for (var day = 0; day < 365; day++)
            {

                for (int hour = 8; hour <= 18; hour++)
                {
                    var date = januaryFirst.AddDays(day).AddHours(hour);
                    var uvIndex = UvIndex(hour, date.Month);
                    var kwhPerSquareMeter = 1 + uvIndex * 16;

                    for (int userId = 0; userId < 10; userId++)
                    {
                        var actualProduction = kwhPerSquareMeter * surfaces[userId];
                        actualProduction = actualProduction + r.Next(-10, 10) / 100m * actualProduction;

                        var row = new DataRow
                                  {
                                      AvgGenArea = kwhPerSquareMeter,
                                      Consumed = r.Next(5, 4000),
                                      DayOfWeek = (int)date.DayOfWeek,
                                      WeekOfYear = DateTimeFormatInfo.CurrentInfo.Calendar.GetWeekOfYear(date, CalendarWeekRule.FirstDay, DayOfWeek.Monday),
                                      HourOfDay = hour,
                                      Month = date.Month,
                                      SolarSurface = surfaces[userId],
                                      UvIndex = uvIndex,
                                      GeneratedSolar = actualProduction
                                  };

                        writer.WriteLine(row);
                    }
                }

            }
        }

        static int UvIndex(int hour, int month)
        {
            var increaseMonth = new Dictionary<int, int>
                                                 {
                                                     { 1, 3 },
                                                     { 2, 5 },
                                                     { 3, 8 },
                                                     { 4, 12 },
                                                     { 5, 13 },
                                                     { 6, 13 },
                                                     { 7, 13 },
                                                     { 8, 11 },
                                                     { 9, 10 },
                                                     { 10, 7 },
                                                     { 11, 3 },
                                                     { 12, 2 }
                                                 };

            var basicHour = new Dictionary<int, int>
                            {
                                { 0, 0 },
                                { 1, 0 },
                                { 2, 0 },
                                { 3, 0 },
                                { 4, 0 },
                                { 5, 0 },
                                { 6, 0 },
                                { 7, 1 },
                                { 8, 2 },
                                { 9, 3 },
                                { 10, 5 },
                                { 11, 8 },
                                { 12, 12 },
                                { 13, 8 },
                                { 14, 5 },
                                { 15, 3 },
                                { 16, 2 },
                                { 17, 2 },
                                { 18, 3 },
                                { 19, 0 },
                                { 20, 0 },
                                { 21, 0 },
                                { 22, 0 },
                                { 23, 0 },
                            };

            return basicHour[hour] * (increaseMonth[month] / 2);
        }


    }
}
