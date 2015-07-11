<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >
	<xsl:template match="/">

		<html>
			<body>
				
				<h1><xsl:value-of select="//language/name"/></h1>
				<h3><xsl:value-of select="//library/name"/>.h</h3>
				
				<xsl:for-each select="//function">
					<p><xsl:value-of select="return_type"/> &#160; <b><xsl:value-of select="name"/></b>(<xsl:for-each select="/argument-list"> 
																									<xsl:value-of select="argument"/> 
																								</xsl:for-each>)</p>
					
					<h4>Function Description: </h4><xsl:value-of select="description"/>
				</xsl:for-each>
			</body>
		</html>

	</xsl:template>
</xsl:stylesheet>