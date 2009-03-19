###########################################################################
#
# This file is auto-generated by the Perl DateTime Suite locale
# generator (0.05).  This code generator comes with the
# DateTime::Locale distribution in the tools/ directory, and is called
# generate-from-cldr.
#
# This file as generated from the CLDR XML locale data.  See the
# LICENSE.cldr file included in this distribution for license details.
#
# This file was generated from the source file fr_CA.xml
# The source file version number was 1.57, generated on
# 2008/06/17 18:53:46.
#
# Do not edit this file directly.
#
###########################################################################

package DateTime::Locale::fr_CA;

use strict;
use warnings;
use utf8;

use base 'DateTime::Locale::fr';

sub cldr_version { return "1\.6\.1" }

{
    my $date_format_medium = "yyyy\-MM\-dd";
    sub date_format_medium { return $date_format_medium }
}

{
    my $date_format_short = "yy\-MM\-dd";
    sub date_format_short { return $date_format_short }
}

{
    my $first_day_of_week = 7;
    sub first_day_of_week { return $first_day_of_week }
}

{
    my $time_format_full = "HH\ \'h\'\ mm\ \'min\'\ ss\ \'s\'\ v";
    sub time_format_full { return $time_format_full }
}

{
    my $_format_for_MEd = "EEE\ M\-d";
    sub _format_for_MEd { return $_format_for_MEd }
}

{
    my $_format_for_MMd = "MM\-d";
    sub _format_for_MMd { return $_format_for_MMd }
}

{
    my $_format_for_MMdd = "MM\-dd";
    sub _format_for_MMdd { return $_format_for_MMdd }
}

{
    my $_format_for_Md = "M\-d";
    sub _format_for_Md { return $_format_for_Md }
}

{
    my $_format_for_yM = "yyyy\-MM";
    sub _format_for_yM { return $_format_for_yM }
}

{
    my $_format_for_yMEd = "EEE\ yyyy\-MM\-dd";
    sub _format_for_yMEd { return $_format_for_yMEd }
}

{
    my $_format_for_yyMM = "yy\-MM";
    sub _format_for_yyMM { return $_format_for_yyMM }
}

{
    my $_available_formats =
        {
          "MEd" => "EEE\ M\-d",
          "MMd" => "MM\-d",
          "MMdd" => "MM\-dd",
          "Md" => "M\-d",
          "yM" => "yyyy\-MM",
          "yMEd" => "EEE\ yyyy\-MM\-dd",
          "yyMM" => "yy\-MM"
        };
    sub _available_formats { return $_available_formats }
}

1;

__END__


=pod

=encoding utf8

=head1 NAME

DateTime::Locale::fr_CA

=head1 SYNOPSIS

  use DateTime;

  my $dt = DateTime->now( locale => 'fr_CA' );
  print $dt->month_name();

=head1 DESCRIPTION

This is the DateTime locale package for French Canada.

=head1 DATA

This locale inherits from the L<DateTime::Locale::fr> locale.

It contains the following data.

=head2 Days

=head3 Wide (format)

  lundi
  mardi
  mercredi
  jeudi
  vendredi
  samedi
  dimanche

=head3 Abbreviated (format)

  lun.
  mar.
  mer.
  jeu.
  ven.
  sam.
  dim.

=head3 Narrow (format)

  L
  M
  M
  J
  V
  S
  D

=head3 Wide (stand-alone)

  lundi
  mardi
  mercredi
  jeudi
  vendredi
  samedi
  dimanche

=head3 Abbreviated (stand-alone)

  lun.
  mar.
  mer.
  jeu.
  ven.
  sam.
  dim.

=head3 Narrow (stand-alone)

  L
  M
  M
  J
  V
  S
  D

=head2 Months

=head3 Wide (format)

  janvier
  février
  mars
  avril
  mai
  juin
  juillet
  août
  septembre
  octobre
  novembre
  décembre

=head3 Abbreviated (format)

  janv.
  févr.
  mars
  avr.
  mai
  juin
  juil.
  août
  sept.
  oct.
  nov.
  déc.

=head3 Narrow (format)

  J
  F
  M
  A
  M
  J
  J
  A
  S
  O
  N
  D

=head3 Wide (stand-alone)

  janvier
  février
  mars
  avril
  mai
  juin
  juillet
  août
  septembre
  octobre
  novembre
  décembre

=head3 Abbreviated (stand-alone)

  janv.
  févr.
  mars
  avr.
  mai
  juin
  juil.
  août
  sept.
  oct.
  nov.
  déc.

=head3 Narrow (stand-alone)

  J
  F
  M
  A
  M
  J
  J
  A
  S
  O
  N
  D

=head2 Quarters

=head3 Wide (format)

  1er trimestre
  2e trimestre
  3e trimestre
  4e trimestre

=head3 Abbreviated (format)

  T1
  T2
  T3
  T4

=head3 Narrow (format)

  T1
  T2
  T3
  T4

=head3 Wide (stand-alone)

  1er trimestre
  2e trimestre
  3e trimestre
  4e trimestre

=head3 Abbreviated (stand-alone)

  T1
  T2
  T3
  T4

=head3 Narrow (stand-alone)

  1
  2
  3
  4

=head2 Eras

=head3 Wide

  avant Jésus-Christ
  après Jésus-Christ

=head3 Abbreviated

  av. J.-C.
  ap. J.-C.

=head3 Narrow

  av. J.-C.
  ap. J.-C.

=head2 Date Formats

=head3 Full

   2008-02-05T12:30:30 = mardi 5 février 2008
   1995-12-22T09:05:02 = vendredi 22 décembre 1995
  -0010-09-15T04:44:23 = samedi 15 septembre -010

=head3 Long

   2008-02-05T12:30:30 = 5 février 2008
   1995-12-22T09:05:02 = 22 décembre 1995
  -0010-09-15T04:44:23 = 15 septembre -010

=head3 Medium

   2008-02-05T12:30:30 = 2008-02-05
   1995-12-22T09:05:02 = 1995-12-22
  -0010-09-15T04:44:23 = -010-09-15

=head3 Short

   2008-02-05T12:30:30 = 8-02-05
   1995-12-22T09:05:02 = 95-12-22
  -0010-09-15T04:44:23 = 10-09-15

=head3 Default

   2008-02-05T12:30:30 = 2008-02-05
   1995-12-22T09:05:02 = 1995-12-22
  -0010-09-15T04:44:23 = -010-09-15

=head2 Time Formats

=head3 Full

   2008-02-05T12:30:30 = 12 h 30 min 30 s UTC
   1995-12-22T09:05:02 = 09 h 05 min 02 s UTC
  -0010-09-15T04:44:23 = 04 h 44 min 23 s UTC

=head3 Long

   2008-02-05T12:30:30 = 12:30:30 UTC
   1995-12-22T09:05:02 = 09:05:02 UTC
  -0010-09-15T04:44:23 = 04:44:23 UTC

=head3 Medium

   2008-02-05T12:30:30 = 12:30:30
   1995-12-22T09:05:02 = 09:05:02
  -0010-09-15T04:44:23 = 04:44:23

=head3 Short

   2008-02-05T12:30:30 = 12:30
   1995-12-22T09:05:02 = 09:05
  -0010-09-15T04:44:23 = 04:44

=head3 Default

   2008-02-05T12:30:30 = 12:30:30
   1995-12-22T09:05:02 = 09:05:02
  -0010-09-15T04:44:23 = 04:44:23

=head2 Datetime Formats

=head3 Full

   2008-02-05T12:30:30 = mardi 5 février 2008 12 h 30 min 30 s UTC
   1995-12-22T09:05:02 = vendredi 22 décembre 1995 09 h 05 min 02 s UTC
  -0010-09-15T04:44:23 = samedi 15 septembre -010 04 h 44 min 23 s UTC

=head3 Long

   2008-02-05T12:30:30 = 5 février 2008 12:30:30 UTC
   1995-12-22T09:05:02 = 22 décembre 1995 09:05:02 UTC
  -0010-09-15T04:44:23 = 15 septembre -010 04:44:23 UTC

=head3 Medium

   2008-02-05T12:30:30 = 2008-02-05 12:30:30
   1995-12-22T09:05:02 = 1995-12-22 09:05:02
  -0010-09-15T04:44:23 = -010-09-15 04:44:23

=head3 Short

   2008-02-05T12:30:30 = 8-02-05 12:30
   1995-12-22T09:05:02 = 95-12-22 09:05
  -0010-09-15T04:44:23 = 10-09-15 04:44

=head3 Default

   2008-02-05T12:30:30 = 2008-02-05 12:30:30
   1995-12-22T09:05:02 = 1995-12-22 09:05:02
  -0010-09-15T04:44:23 = -010-09-15 04:44:23

=head2 Available Formats

=head3 HHmm (HH:mm)

   2008-02-05T12:30:30 = 12:30
   1995-12-22T09:05:02 = 09:05
  -0010-09-15T04:44:23 = 04:44

=head3 HHmmss (HH:mm:ss)

   2008-02-05T12:30:30 = 12:30:30
   1995-12-22T09:05:02 = 09:05:02
  -0010-09-15T04:44:23 = 04:44:23

=head3 Hm (H:mm)

   2008-02-05T12:30:30 = 12:30
   1995-12-22T09:05:02 = 9:05
  -0010-09-15T04:44:23 = 4:44

=head3 M (L)

   2008-02-05T12:30:30 = 2
   1995-12-22T09:05:02 = 12
  -0010-09-15T04:44:23 = 9

=head3 MEd (EEE M-d)

   2008-02-05T12:30:30 = mar. 2-5
   1995-12-22T09:05:02 = ven. 12-22
  -0010-09-15T04:44:23 = sam. 9-15

=head3 MMM (LLL)

   2008-02-05T12:30:30 = févr.
   1995-12-22T09:05:02 = déc.
  -0010-09-15T04:44:23 = sept.

=head3 MMMEd (E d MMM)

   2008-02-05T12:30:30 = mar. 5 févr.
   1995-12-22T09:05:02 = ven. 22 déc.
  -0010-09-15T04:44:23 = sam. 15 sept.

=head3 MMMMEd (EEE d MMMM)

   2008-02-05T12:30:30 = mar. 5 février
   1995-12-22T09:05:02 = ven. 22 décembre
  -0010-09-15T04:44:23 = sam. 15 septembre

=head3 MMMMd (d MMMM)

   2008-02-05T12:30:30 = 5 février
   1995-12-22T09:05:02 = 22 décembre
  -0010-09-15T04:44:23 = 15 septembre

=head3 MMMd (d MMM)

   2008-02-05T12:30:30 = 5 févr.
   1995-12-22T09:05:02 = 22 déc.
  -0010-09-15T04:44:23 = 15 sept.

=head3 MMMdd (dd MMM)

   2008-02-05T12:30:30 = 05 févr.
   1995-12-22T09:05:02 = 22 déc.
  -0010-09-15T04:44:23 = 15 sept.

=head3 MMd (MM-d)

   2008-02-05T12:30:30 = 02-5
   1995-12-22T09:05:02 = 12-22
  -0010-09-15T04:44:23 = 09-15

=head3 MMdd (MM-dd)

   2008-02-05T12:30:30 = 02-05
   1995-12-22T09:05:02 = 12-22
  -0010-09-15T04:44:23 = 09-15

=head3 Md (M-d)

   2008-02-05T12:30:30 = 2-5
   1995-12-22T09:05:02 = 12-22
  -0010-09-15T04:44:23 = 9-15

=head3 d (d)

   2008-02-05T12:30:30 = 5
   1995-12-22T09:05:02 = 22
  -0010-09-15T04:44:23 = 15

=head3 hhmm (HH:mm)

   2008-02-05T12:30:30 = 12:30
   1995-12-22T09:05:02 = 09:05
  -0010-09-15T04:44:23 = 04:44

=head3 hhmmss (HH:mm:ss)

   2008-02-05T12:30:30 = 12:30:30
   1995-12-22T09:05:02 = 09:05:02
  -0010-09-15T04:44:23 = 04:44:23

=head3 mmss (mm:ss)

   2008-02-05T12:30:30 = 30:30
   1995-12-22T09:05:02 = 05:02
  -0010-09-15T04:44:23 = 44:23

=head3 ms (mm:ss)

   2008-02-05T12:30:30 = 30:30
   1995-12-22T09:05:02 = 05:02
  -0010-09-15T04:44:23 = 44:23

=head3 y (yyyy)

   2008-02-05T12:30:30 = 2008
   1995-12-22T09:05:02 = 1995
  -0010-09-15T04:44:23 = -010

=head3 yM (yyyy-MM)

   2008-02-05T12:30:30 = 2008-02
   1995-12-22T09:05:02 = 1995-12
  -0010-09-15T04:44:23 = -010-09

=head3 yMEd (EEE yyyy-MM-dd)

   2008-02-05T12:30:30 = mar. 2008-02-05
   1995-12-22T09:05:02 = ven. 1995-12-22
  -0010-09-15T04:44:23 = sam. -010-09-15

=head3 yMMM (MMM yyyy)

   2008-02-05T12:30:30 = févr. 2008
   1995-12-22T09:05:02 = déc. 1995
  -0010-09-15T04:44:23 = sept. -010

=head3 yMMMEd (EEE d MMM yyyy)

   2008-02-05T12:30:30 = mar. 5 févr. 2008
   1995-12-22T09:05:02 = ven. 22 déc. 1995
  -0010-09-15T04:44:23 = sam. 15 sept. -010

=head3 yMMMM (MMMM yyyy)

   2008-02-05T12:30:30 = février 2008
   1995-12-22T09:05:02 = décembre 1995
  -0010-09-15T04:44:23 = septembre -010

=head3 yQ ('T'Q yyyy)

   2008-02-05T12:30:30 = T1 2008
   1995-12-22T09:05:02 = T4 1995
  -0010-09-15T04:44:23 = T3 -010

=head3 yQQQ (QQQ yyyy)

   2008-02-05T12:30:30 = T1 2008
   1995-12-22T09:05:02 = T4 1995
  -0010-09-15T04:44:23 = T3 -010

=head3 yyMM (yy-MM)

   2008-02-05T12:30:30 = 8-02
   1995-12-22T09:05:02 = 95-12
  -0010-09-15T04:44:23 = 10-09

=head3 yyMMM (MMM yy)

   2008-02-05T12:30:30 = févr. 8
   1995-12-22T09:05:02 = déc. 95
  -0010-09-15T04:44:23 = sept. 10

=head3 yyMMMEEEd (EEE d MMM yy)

   2008-02-05T12:30:30 = mar. 5 févr. 8
   1995-12-22T09:05:02 = ven. 22 déc. 95
  -0010-09-15T04:44:23 = sam. 15 sept. 10

=head3 yyMMMd (d MMM yy)

   2008-02-05T12:30:30 = 5 févr. 8
   1995-12-22T09:05:02 = 22 déc. 95
  -0010-09-15T04:44:23 = 15 sept. 10

=head3 yyQ ('T'Q yy)

   2008-02-05T12:30:30 = T1 8
   1995-12-22T09:05:02 = T4 95
  -0010-09-15T04:44:23 = T3 10

=head3 yyQQQQ (QQQQ yy)

   2008-02-05T12:30:30 = 1er trimestre 8
   1995-12-22T09:05:02 = 4e trimestre 95
  -0010-09-15T04:44:23 = 3e trimestre 10

=head3 yyyyMMMM (MMMM yyyy)

   2008-02-05T12:30:30 = février 2008
   1995-12-22T09:05:02 = décembre 1995
  -0010-09-15T04:44:23 = septembre -010

=head2 Miscellaneous

=head3 Prefers 24 hour time?

Yes

=head3 Local first day of the week

dimanche


=head1 SUPPORT

See L<DateTime::Locale>.

=head1 AUTHOR

Dave Rolsky <autarch@urth.org>

=head1 COPYRIGHT

Copyright (c) 2008 David Rolsky. All rights reserved. This program is
free software; you can redistribute it and/or modify it under the same
terms as Perl itself.

This module was generated from data provided by the CLDR project, see
the LICENSE.cldr in this distribution for details on the CLDR data's
license.

=cut
