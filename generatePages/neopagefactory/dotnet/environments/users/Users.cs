using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Serialization;

namespace environments.users
{
    [Serializable()]
    [XmlRoot("Users")]
    public class Users : IEnvironments
    {
        [XmlElement("User")]
        public User[] User;

        public User GetUserUsingBddIdentifier(string bddidentifier)
        {
            IEnumerable<User> user = 
                User.Where(item=>item.BddIdentifier.ToUpper().Trim().Equals(bddidentifier.ToUpper().Trim()));

            User theUser = null;

            if( user != null )
            {
                if( user.ToArray().Length ==  0)
                {
                    throw new Exception("[ERR] User identifier " + bddidentifier + " does not exist for the environment (specified in app.config as 'environment')");
                }
                else
                {
                    theUser = user.ToArray()[0];
                }
            }

            return theUser;
        }
    }
}
