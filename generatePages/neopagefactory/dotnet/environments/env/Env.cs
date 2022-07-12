using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Xml.Serialization;


namespace environments.env
{
    [Serializable()]
    [XmlRoot("Env")]
    public class Env : IEnvironments
    {
        [XmlElement("Url")]
        public Url[] Url;

        [XmlElement("XPath")]
        public XPath[] XPath;

        [XmlElement("Property")]
        public Property[] Property;

        public static Env GetEnv()
        {
            return 
                GetTypeUsingEnvironmentSettings(typeof(Env), EnvironmentFileEnum.env) as Env;
        }

        public string GetProperty(string propertyName)
        {
            string value = null;

            if (Property != null)
            {
                foreach (Property property in Property)
                {
                    if (property.Name.Equals(propertyName))
                    {
                        value = property.Value; break;
                    }
                }
            }

            return value;
        }

        public string GetXPath(string xPathName)
        {
            string xPath = null;

            if(XPath!=null)
            {
                foreach(XPath path in XPath)
                {
                    if (path.Name.Equals(xPathName))
                    {
                        xPath = path.Value; break;
                    }
                }
            }

            if(xPath==null)
            {
                throw new Exception("[ERR] XPath for " + xPathName + " does not exist in environment file");
            }

            return xPath;
        }

        public static string GetNpsHost()
        {
            Env env = Env.GetEnv();

            string url =  env.Url[0].Value;

            Match m = Regex.Match(url, "([a-z]*://[^/]*)");

            string host = null;

            if( m.Success )
            {
                host = m.Groups[1].Value;
            }

            return host;
        }
    }
}
