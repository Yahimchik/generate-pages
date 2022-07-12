using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Serialization;

namespace environments.users
{
    [Serializable()]
    [XmlRoot("User")]
    public class User
    {
        [XmlAttribute("bddidentifier")]
        public string BddIdentifier;

        [XmlAttribute("login")]
        public string Login;

        [XmlAttribute("password")]
        public string Password;
    }
}
