using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Serialization;

namespace environments.env
{
    [Serializable()]
    [XmlRoot("Env")]
    public class Property
    {
        [XmlAttribute("name")]
        public string Name;

        [XmlAttribute("value")]
        public string Value;
    }
}
