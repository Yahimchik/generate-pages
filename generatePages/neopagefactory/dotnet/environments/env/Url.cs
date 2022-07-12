using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Serialization;

namespace environments.env
{
    [Serializable()]
    [XmlRoot("Url")]
    public class Url
    {
        [XmlAttribute("bddidentifier")]
        public string BddIdentifier;

        [XmlAttribute("value")]
        public string Value;
    }
}
