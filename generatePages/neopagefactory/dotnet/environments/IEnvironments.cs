using System;
using uk.org.hs2.genericutils;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Serialization;

namespace environments
{
    [Serializable()]
    public abstract class IEnvironments
    {
        public static IEnvironments GetTypeUsingEnvironmentSettings(Type type, EnvironmentFileEnum environmentFileType)
        {
            string environment = AppSettings.Get("environment");

            IEnvironments env = null;

            string rootDir = GenericUtils.GetRootFolder();

            using (StreamReader r = new StreamReader(rootDir + @"\resources\environmentproperties\" + environment +@"\" + environmentFileType.ToString() + ".xml"))
            {
                XmlSerializer serializer = new XmlSerializer(type);

                env = serializer.Deserialize(r) as IEnvironments;

                r.Close();
            }

            return env;
        }
    }
}
