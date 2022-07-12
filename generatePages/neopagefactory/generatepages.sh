# Author	: Des McCarter
# Description	: Generates Page (Object Pattern) class files
# Arguments	:
#	-url	: The URL
#	-root	: [OPTIONAL] The root folder from which page class files are generated. Current working directory is default.
#	-package: [OPTIONAL] The java package which all generated page class files will live under
#	-html	: [OPTIONAL] The HTML file which contains all page elements. It will be this file that will be used to generate page classes (as opposed to the -url argument
#		: which is STILL needed (but will not be used as the source for page class generation).

args="${*}"

####################################
# Exceuting via POM: Examples ...  #
####################################

##################
# Google.com ... #
##################

#mvn clean install "exec:java" -Durl=https://www.google.com -Dpackage="com.dmcc.sample.pages.google" -Dsrc.root=../pgenexamples/src/test/java -Dresources.root=../pgenexamples/src/test/resources

##################
# Ocado.com ...  #
##################

#mvn clean install "exec:java" -Durl=https://www.ocado.com/webshop/quickReg.do -Dpackage="com.dmcc.sample.pages.ocado" -Dsrc.root=../pgenexamples/src/test/java -Dresources.root=../pgenexamples/src/test/resources

##################
# Expedia.com	 #
##################

#mvn clean install "exec:java" -Durl=https://www.expedia.co.uk -Dpackage="com.dmcc.sample.pages.expedia" -Dsrc.root=../pgenexamples/src/test/java -Dresources.root=../pgenexamples/src/test/resources

##############################################
# HSBC (using text HTML text file as source) #
##############################################

#mvn clean install "exec:java" -Duse.file=true -Durl=https://www.hsbc.co.uk -Dfile=hsbc.html -Dpackage="com.dmcc.sample.pages.hsbc" -Dsrc.root=../pgenexamples/src/test/java -Dresources.root=../pgenexamples/src/test/resources

#########################################################
# LLoyds Bank.com (using HTML text file as HTML source) #
#########################################################

#mvn clean install "exec:java" -Duse.file=true -Dfile=lloydsbank.html -Durl=https://www.lloydsbank.com -Dpackage="com.dmcc.sample.pages.lloydsbank" -Dsrc.root=../pgenexamples/src/test/java -Dresources.root=../pgenexamples/src/test/resources

##################################################
# Instagram.com	 (using HTML text file as source #
##################################################

#mvn clean install "exec:java" -Duse.file=true -Dfile=instagram.html -Durl=https://www.instagram.com -Dpackage="com.dmcc.sample.pages.instagram" -Dsrc.root=../pgenexamples/src/test/java -Dresources.root=../pgenexamples/src/test/resources

#####################################################
#  Last Minute.com (using HTML text file as source) #
#####################################################

#mvn clean install "exec:java" -Duse.file=true -Dfile=lastminute.html -Durl=https://www.lastminute.com -Dpackage="com.dmcc.sample.pages.lastminute" -Dsrc.root=../pgenexamples/src/test/java -Dresources.root=../pgenexamples/src/test/resources

defaultpackage="com.dmcc.sample.pages"
script="$(basename ${0})"

function usage(){
	printf "[USAGE]:\n"
	printf "\t%s -url \"the url\" [-file \"the source HTML file\": optional]\n" "${script}"
}

function error(){
	printf "[ERR] %-30s\n" "${1}"
}

function info(){
	printf "[INFO] %-30s\n" "${1}"
}

function errorAndUsage(){
	error "${1}"
	usage
}
function show(){

	argname="${1}"
	argvalue="${2}"

	printf "%-20s: %-40s\n" "${argname}" "${argvalue}"
}

function generate(){

	url="${1}"
	package="${2}"
	root="${3}"
	file="${4}"

	if [[ -z "${url}" ]]
	then
		echo "[ERR] url not given"

		return 1
	fi

	if [[ ! -z "${file}" ]]
	then
		usefileargs="-Duse.file=true -Dfile=${file}"
	else
		unset usefileargs
	fi

	show "URL" "${url}"
	show "BASE PACKAGE" "${package}"
	show "ROOT FOLDER" "${root}"

	if [[ ! -z "${file}" ]]
	then
		show "SOURCED FROM" "${file}"
	else
		show "SOURCED FROM" "${url}"
	fi

	cd ~/projects/neopagefactory

	mvn clean install "exec:java" ${usefileargs} -Durl=${url} -Dpackage="${package}" -Dsrc.root=${root}/src/test/java -Dresources.root=${root}/src/test/resources

	res="${?}"

	cd  -

	if [[ "${res}" == "0" ]]
	then
		info " Successfully generated pages"
		return 0
	else
		echo "[ERR] Failed to generate pages"
		return 1
	fi
}


function processArgs(){
	while [[ ! -z "${1}" ]]
	do
		if [[ "${1}" == "-url" ]]
		then
			shift

			if [[ -z "${1}" ]]
			then
				errorAndUsage "-url flag requires a supplemental argument (the URL)"
				return 1
			fi

			URL="${1}"
		elif [[ "${1}" == "-root" ]]
		then
			shift

			if [[ -z "${1}" ]]
			then
				errorAndUsage "-root flag requires a supplemental argument (the root folder)"
				return 1
			fi

			ROOT="${1}"
		elif [[ "${1}" == "-package" ]]
		then
			shift

			if [[ -z "${1}" ]]
			then
				errorAndUsage "-package flag requires a supplemental argument (the name of the package which will contain all page classes. Default is ${defaultpackage})"
				return 1
			fi

			PACKAGE="${1}"
		elif [[ "${1}" == "-htmlfile" ]]
		then
			shift

			if [[ -z "${1}" ]]
			then
				errorAndUsage "-htmlfile flag requires a supplemental argument (the name of the HTML file containing elements to be used to generate page classes)"
				return 1
			fi

			PACKAGE="${1}"
		fi
		
		shift
	done
}

function exitOnError(){
	if [[ "${1}" != "0" ]]
	then
		exit "${1}"
	fi
}

function verifyArgs(){
	if [[ -z "${URL}" ]]
	then
		errorAndUsage "-url flag not given"
		return 1
	fi

	if [[ -z "${PACKAGE}" ]]
	then
		pname="$(echo ${URL} | sed -n s/"^http[s]*:[\/]*[w|\.]*\([^\.]*\).*$"/"\1"/p)"

		if [[ -z "${pname}" ]]
		then
			error "Failed to generate packagename from URL ${URL}"
			return 1
		fi

		PACKAGE="${defaultpackage}.${pname}"
	fi

	if [[ -z "${ROOT}" ]]
	then
		ROOT="."
	elif [[ ! -d "${ROOT}" ]]
	then
		mkdir "${ROOT}"
	fi

	packagefolder="${ROOT}/src/test/java/$(echo "${PACKAGE}" | sed  s/"\."/"\/"/g)"

	if [[ ! -d "${packagefolder}" ]]
	then
		info "Creating page class folder ${packagefolder} ..."

		mkdir -p ${packagefolder}

		res="${?}"

		if [[ "${res}" != "0" ]]
		then
			error "Failed to create page class folder ${packagefolder}"
			return 1
		fi

		info "Done."

	fi

	show "URL" "${URL}"
	show "PACKAGE" "${PACKAGE}"
	show "ROOT" "${ROOT}"

	if [[ -z "${HTMLSOURCEFILE}" ]]
	then
		show "HTMLSOURCEFILE" "${HTMLSOURCEFILE}"
	fi
}

# Process all arguments fed into this script ...
processArgs ${*}

# Exit script on any arg processing errors ...
exitOnError "${?}"

# Verify arguments fed into this script ...
verifyArgs

# Exit script on any arg validation errors ...
exitOnError "${?}"

# Generate page classes ...
generate "${URL}" "${PACKAGE}" "${ROOT}" "${HTMLSOURCEFILE}"

# Exit script ...
exit "${?}"

