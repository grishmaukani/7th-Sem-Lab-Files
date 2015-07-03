<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/transform" >
	<xsl:template match="/">

		<html>
			<body>
				<xsl:for-each select="programming_language/language/library/function">
					<p><xsl:value-of select="name"/></p>
				</xsl:for-each>
			</body>
		</html>

	</xsl:template>
</xsl:stylesheet>