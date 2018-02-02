<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
<head>
<title>Table of <xsl:value-of select="name(/*[1])"/></title>
</head>
<body >
<h1 style="background-color: #FA1561;
color: #FFFFFF; font-size: 20pt; text-align: center;
letter-spacing: 1.0em"><xsl:value-of select="name(/*[1])"/></h1>
<table align="center" border="2">
<tr>
<xsl:apply-templates select="/*/*[1]/@*|/*/*[1]/*"/>
</tr>
<xsl:apply-templates select="/*/*"/>
</table>
</body>
</html>
</xsl:template>
<!-- ///////////////////////////////////////////////////////////////// -->
<xsl:template match="/*/*[1]/@*">
<th><xsl:value-of select="name(.)"/>(a)</th>
</xsl:template>
<!-- ///////////////////////////////////////////////////////////////// -->
<xsl:template match="/*/*[1]/*">
<th>
<xsl:value-of select="name(.)"/>(c)</th>
</xsl:template>
<!-- ///////////////////////////////////////////////////////////////// -->
<xsl:template match="/*/*">
<tr>
<xsl:for-each select="@*|*"><td><xsl:value-of select="."/></td></xsl:for-each>
</tr>
</xsl:template>
<!-- ///////////////////////////////////////////////////////////////// -->
</xsl:stylesheet>
