using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace uk.org.hs2.genericutils
{
    public class GenericUtils
    {
        private static Random random = new Random();

        private static string tempFolder = null;

        public static string TempFolder
        {
            get
            {
                if (tempFolder == null)
                {
                    tempFolder = AppSettings.Get("temp.folder");

                    // *** if this is an environment variable then get it ...
                    if (Regex.Match(tempFolder, @"^[ ]*\%").Success)
                    {
                        tempFolder = Environment.GetEnvironmentVariable(tempFolder);
                    }
                }

                return tempFolder;
            }
        }

        public static string GetRandomString(int length)
        {
            const string chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

            return new string(Enumerable.Repeat(chars, length)
              .Select(s => s[random.Next(s.Length)]).ToArray());
        }

        public static string GetRandomDigits(int length)
        {
            const string chars = "0123456789";

            return new string(Enumerable.Repeat(chars, length)
              .Select(s => s[random.Next(s.Length)]).ToArray());
        }

        public static void CreateFolder(string folder)
        {
            if( !Directory.Exists(folder) )
            {
                Directory.CreateDirectory(folder);
            }
        }

        public static void CreateTextContentFile(string file, string content)
        {
            if (System.IO.File.Exists(file))
            {
                System.IO.File.Delete(file);
            }

            using (System.IO.StreamWriter writer = System.IO.File.CreateText(file))
            {
                writer.Write(content);
            }
        }

        public static string GetRootFolder()
        {
            return AppDomain.CurrentDomain.BaseDirectory;
        }
    }
}
