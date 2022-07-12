using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using pagefactory.xml;
using Newtonsoft.Json;
using System.IO;
using System.Runtime.Remoting.Messaging;

namespace pagefactory.json
{
    public class PagesJson
    {
        public VersionControl VersionControl;
        public UsageInstructions UsageInstructions;
        public Page[] Pages;

        public static Page[] GetPages(string jsonFile)
        {
            return DeserializePages(jsonFile);
        }

        protected static Page[] DeserializePages(string jsonfile)
        {
            Page[] page = null;

            using (StreamReader r = new StreamReader(jsonfile))
            {
                PagesJson[] pagesjson = JsonConvert.DeserializeObject<PagesJson[]>(r.ReadToEnd());

                if ( (pagesjson != null) && (pagesjson.Length>=1))
                {
                    page = pagesjson[0].Pages;
                }
            }

            return page;
        }
    }
}
